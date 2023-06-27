package com.wh.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wh.entities.Bid;
import com.wh.entities.Order;
import com.wh.repositories.OrderRepository;



public class OrderServiceImplTest {
	
	private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
    }
    
    @Test
    public void createOrder_ValidOrder_ReturnsCreatedOrder() {
        Order order = mock(Bid.class);
        order.setPrice(10.5);

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertTrue(order instanceof Bid);
        assertEquals(order.getPrice(), createdOrder.getPrice());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void getOrderById_ExistingOrderId_ReturnsOrderOptional() {
        Long orderId = 1L;
        Order order = mock(Order.class);
        order.setId(orderId);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.getOrderById(orderId);

        assertTrue(result.isPresent());
        verify(orderRepository, times(1)).findById(orderId);
    }
    
    @Test
    public void getOrderById_NonExistingOrderId_ReturnsEmptyOptional() {
        Long orderId = 1L;

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Optional<Order> result = orderService.getOrderById(orderId);

        assertFalse(result.isPresent());
        verify(orderRepository, times(1)).findById(orderId);
    }
    
    @Test
    public void getAllOrders_NoOrders_ReturnsEmptyList() {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());

        List<Order> orders = orderService.getAllOrders();

        assertNotNull(orders);
        assertTrue(orders.isEmpty());
        verify(orderRepository, times(1)).findAll();
    }
    
    @Test
    public void getAllOrders_ExistingOrders_ReturnsOrderList() {
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(mock(Order.class));
        mockOrders.add(mock(Order.class));

        when(orderRepository.findAll()).thenReturn(mockOrders);

        List<Order> orders = orderService.getAllOrders();

        assertNotNull(orders);
        assertEquals(mockOrders.size(), orders.size());
        verify(orderRepository, times(1)).findAll();
    }
    
    @Test
    public void testUpdateOrder_CallsRepositoryUpdateOrderPrice() {
        // Arrange
        long orderId = 1L;
        double updatedPrice = 19.99;

        // Act
        orderService.updateOrder(orderId, updatedPrice);

        // Assert
        verify(orderRepository, times(1)).updateOrderPrice(orderId, updatedPrice);
    }
    
}
