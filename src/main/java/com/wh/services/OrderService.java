package com.wh.services;
import com.wh.entities.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
	
	Order createOrder(Order order);
	
	Optional<Order> getOrderById(Long orderId);
	
	List<Order> getAllOrders();
	
	void updateOrder(Order updatedOrder);
	
	void deleteOrder(Long orderId);

}
