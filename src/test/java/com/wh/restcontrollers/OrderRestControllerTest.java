package com.wh.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wh.entities.Order;
import com.wh.services.OrderService;



public class OrderRestControllerTest {
	
	@Mock
    private OrderService orderService;

    @InjectMocks
    private OrderRestController orderRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void createOrder_ReturnsCreatedOrder() {
        Order order = mock(Order.class);
        when(orderService.createOrder(order)).thenReturn(order);

        ResponseEntity<Order> response = orderRestController.createOrder(order);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());
        verify(orderService, times(1)).createOrder(order);
    }
    
    @Test
    void getOrderById_ExistingOrder_ReturnsOrder() {
        Long orderId = 1L;
        Order order = mock(Order.class);
        when(orderService.getOrderById(orderId)).thenReturn(Optional.of(order));

        ResponseEntity<Order> response = orderRestController.getOrderById(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
    }
    
    @Test
    void getOrderById_NonExistingOrder_ReturnsNotFound() {
        Long orderId = 1L;
        when(orderService.getOrderById(orderId)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderRestController.getOrderById(orderId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
    }
    
    @Test
    void getAllOrders_ReturnsAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(mock(Order.class));
        orders.add(mock(Order.class));
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderRestController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
        verify(orderService, times(1)).getAllOrders();
    }
    
    @Test
    public void testUpdateOrder_ExistingOrder_ReturnsUpdatedOrder() {
        // Arrange
        Order order = mock(Order.class);

        double newPrice = 1.50;
        when(orderService.getOrderById(order.getId())).thenReturn(Optional.of(order));
        
        // Act
        ResponseEntity<Order> response = orderRestController.updateOrder(order.getId(), newPrice);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(orderService, times(1)).updateOrder(order.getId(), newPrice);
    }
    
//    @Test
//    public void testUpdateOrder_NonExistingOrder_ReturnsNotFound() {
//        // Arrange
//        Long orderId = 1L;
//        Order updatedOrder = new Order();
//        updatedOrder.setId(orderId);
//
//        when(orderService.getOrderById(orderId)).thenReturn(Optional.empty());
//
//        // Act
//        ResponseEntity<Order> response = orderRestController.updateOrder(orderId, updatedOrder);
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals(null, response.getBody());
//
//        verify(orderService, times(1)).getOrderById(orderId);
//        verify(orderService, never()).updateOrder(updatedOrder);
//    }

    
    @Test
    void deleteOrder_ExistingOrder_ReturnsNoContent() {
    	Long orderId = 1L;
    	Order existingOrder = mock(Order.class);
    	when(orderService.getOrderById(orderId)).thenReturn(Optional.of(existingOrder));
    	ResponseEntity<Void> response = orderRestController.deleteOrder(orderId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
        verify(orderService, times(1)).deleteOrder(orderId);
    }
    
    @Test
    void deleteOrder_NonExistingOrder_ReturnsNotFound() {
        Long orderId = 1L;
        when(orderService.getOrderById(orderId)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = orderRestController.deleteOrder(orderId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
        verify(orderService, never()).deleteOrder(orderId);
    }
 
    
}