package com.wh.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Exchange {

	@Id
	private String code;
	private String name;
	private double feeLadder;
	
	@OneToMany(mappedBy = "exchangeCode")
	private List<OrderBook> orderBooks;
	
	private double currentDaysTotalTradeValue;

	public Exchange() {
		super();
	}

	public Exchange(String code, String name, double feeLadder, List<OrderBook> orderBooks,
			double currentDaysTotalTradeValue) {
		super();
		this.code = code;
		this.name = name;
		this.feeLadder = feeLadder;
		this.orderBooks = orderBooks;
		this.currentDaysTotalTradeValue = currentDaysTotalTradeValue;
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

	public double getFeeLadder() {
		return feeLadder;
	}

	public void setFeeLadder(double feeLadder) {
		this.feeLadder = feeLadder;
	}

	public List<OrderBook> getOrderBooks() {
		return orderBooks;
	}

	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}

	public double getCurrentDaysTotalTradeValue() {
		return currentDaysTotalTradeValue;
	}

	public void setCurrentDaysTotalTradeValue(double currentDaysTotalTradeValue) {
		this.currentDaysTotalTradeValue = currentDaysTotalTradeValue;
	}
	
	
}
