package com.wh.services;

import com.wh.entities.Order;
import com.wh.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



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
    void createOrder_ValidOrder_ReturnsCreatedOrder() {
        Order order = new Order();
        order.setBuy(true);
        order.setPrice(10.5);

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals(order.isBuy(), createdOrder.isBuy());
        assertEquals(order.getPrice(), createdOrder.getPrice());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void getOrderById_ExistingOrderId_ReturnsOrderOptional() {
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.getOrderById(orderId);

        assertTrue(result.isPresent());
        assertEquals(orderId, result.get().getId());
        verify(orderRepository, times(1)).findById(orderId);
    }
    
    @Test
    void getOrderById_NonExistingOrderId_ReturnsEmptyOptional() {
        Long orderId = 1L;

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Optional<Order> result = orderService.getOrderById(orderId);

        assertFalse(result.isPresent());
        verify(orderRepository, times(1)).findById(orderId);
    }
    
    @Test
    void getAllOrders_NoOrders_ReturnsEmptyList() {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());

        List<Order> orders = orderService.getAllOrders();

        assertNotNull(orders);
        assertTrue(orders.isEmpty());
        verify(orderRepository, times(1)).findAll();
    }
    
    @Test
    void getAllOrders_ExistingOrders_ReturnsOrderList() {
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order());
        mockOrders.add(new Order());

        when(orderRepository.findAll()).thenReturn(mockOrders);

        List<Order> orders = orderService.getAllOrders();

        assertNotNull(orders);
        assertEquals(mockOrders.size(), orders.size());
        verify(orderRepository, times(1)).findAll();
    }
    
    @Test
    void updateOrder_ExistingOrder_ReturnsUpdatedOrder() {
        // Create a sample order
        Order existingOrder = new Order();
        existingOrder.setId(1L);
        existingOrder.setPrice(10.0);

        // Stub the save method to return the updated order
        when(orderRepository.save(existingOrder)).thenReturn(existingOrder);

        // Update the order
        Order updatedOrder = orderService.updateOrder(existingOrder);

        // Verify that the save method was invoked once with the existing order
        verify(orderRepository, times(1)).save(existingOrder);

        // Additional assertions
        assertEquals(existingOrder.getPrice(), updatedOrder.getPrice());
    }


    

}
