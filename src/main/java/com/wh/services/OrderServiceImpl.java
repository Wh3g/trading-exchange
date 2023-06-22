package com.wh.services;
import com.wh.entities.Order;
import com.wh.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public Optional<Order> getOrderById(Long orderId) {
		
		return orderRepository.findById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
	}

	@Override 
	public Order updateOrder(Order updatedOrder) {
		
		return orderRepository.save(updatedOrder);
	}


	@Override
	public void deleteOrder(Long orderId) {
		
		orderRepository.deleteById(orderId);
		
	}

}
