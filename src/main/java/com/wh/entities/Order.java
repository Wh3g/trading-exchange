
package com.wh.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long Id;
	
	private boolean isBuy;
	private double price;
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private OrderBook code;
	
	//creating constructors, getters and setter methods
	
	public Order() {
		
	}
	
	//getter and setter methods for other attributes
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public boolean isBuy() {
		
		return isBuy;
	}

	public void setBuy(boolean buy) {
		
		isBuy = buy;
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public void setPrice(double price) {
		
		this.price = price;
	}
	
	public LocalDateTime getTimestamp() {
		
		return timestamp;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		
		this.timestamp = timestamp;
	}
	
	public User getUser() {
		
		return user;
	}
	
	public void setUser(User user) {
		
		this.user = user;
	}
	
	
}
