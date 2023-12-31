package com.wh.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrderBook {

	@Id
	private String code;
	private String name;
	
	@OneToMany(mappedBy = "code")
	private List<Order> orders;
	
	@ManyToOne
	@JoinColumn(name = "exchangeCode")
	private Exchange exchangeCode;

	public OrderBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderBook(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Exchange getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(Exchange exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	
}
