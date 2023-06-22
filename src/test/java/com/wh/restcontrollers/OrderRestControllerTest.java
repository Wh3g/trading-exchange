package com.wh.restcontrollers;

import com.wh.entities.Order;
import com.wh.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



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
        Order order = new Order();
        Order createdOrder = new Order();
        when(orderService.createOrder(order)).thenReturn(createdOrder);

        ResponseEntity<Order> response = orderRestController.createOrder(order);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdOrder, response.getBody());
        verify(orderService, times(1)).createOrder(order);
    }
    
    @Test
    void getOrderById_ExistingOrder_ReturnsOrder() {
        Long orderId = 1L;
        Order order = new Order();
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
        orders.add(new Order());
        orders.add(new Order());
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderRestController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
        verify(orderService, times(1)).getAllOrders();
    }
    
    @Test
    void updateOrder_ExistingOrder_ReturnsUpdatedOrder() {
        Long orderId = 1L;
        Order existingOrder = new Order();
        Order updatedOrder = new Order();
        when(orderService.getOrderById(orderId)).thenReturn(Optional.of(existingOrder));
        when(orderService.updateOrder(existingOrder)).thenReturn(updatedOrder);

        ResponseEntity<Order> response = orderRestController.updateOrder(orderId, existingOrder);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedOrder, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
        verify(orderService, times(1)).updateOrder(existingOrder);
    }
    
    @Test
    void updateOrder_NonExistingOrder_ReturnsNotFound() {
        Long orderId = 1L;
        Order updatedOrder = new Order();
        when(orderService.getOrderById(orderId)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderRestController.updateOrder(orderId, updatedOrder);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(orderService, times(1)).getOrderById(orderId);
        verify(orderService, never()).updateOrder(updatedOrder);
    }
    
    @Test
    void deleteOrder_ExistingOrder_ReturnsNoContent() {
    	Long orderId = 1L;
    	Order existingOrder = new Order();
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