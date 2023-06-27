package com.wh.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.entities.Order;
import com.wh.repositories.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

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
	public void updateOrder(long orderId, double price) {
		
		orderRepository.updateOrderPrice(orderId, price);
	}


	@Override
	public void deleteOrder(Long orderId) {
		
		orderRepository.deleteById(orderId);
		
	}

}
