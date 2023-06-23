package com.wh.services;
import com.wh.entities.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
	
	public Order createOrder(Order order);
	
	public Optional<Order> getOrderById(Long orderId);
	
	public List<Order> getAllOrders();
	
	public void updateOrder(long orderId, double price);
	
	public void deleteOrder(Long orderId);

}
