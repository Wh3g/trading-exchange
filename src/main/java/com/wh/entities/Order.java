
package com.wh.entities;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private double price;
	private LocalDateTime timestamp;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private OrderBook code;
	
	//creating constructors, getters and setter methods
	
	public Order() {
		
	}
	
	public Order(double price, User user, OrderBook code) {
		super();
		this.price = price;
		this.user = user;
		this.code = code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderBook getCode() {
		return code;
	}

	public void setCode(OrderBook code) {
		this.code = code;
	}
	
}
