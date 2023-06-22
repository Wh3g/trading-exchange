
package com.wh.restcontrollers;

import com.wh.entities.Order;
import com.wh.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")

public class OrderRestController {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderRestController(OrderService orderService) {
		
		this.orderService = orderService;
	}
	
	@PostMapping("/orders/{orderId}")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		
		Order createdOrder = orderService.createOrder(order);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@GetMapping("/orders/{orderId}")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
	
	@PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        Optional<Order> existingOrder = orderService.getOrderById(orderId);
        if (existingOrder.isPresent()) {
            updatedOrder.setId(orderId);
            Order updated = orderService.updateOrder(updatedOrder);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	 
	@DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        Optional<Order> existingOrder = orderService.getOrderById(orderId);
        if (existingOrder.isPresent()) {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
