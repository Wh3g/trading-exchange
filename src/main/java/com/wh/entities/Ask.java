package com.wh.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ask")
public class Ask extends Order {

	public Ask() {
		// TODO Auto-generated constructor stub
	}

	public Ask(double price, User user, OrderBook code) {
		super(price, user, code);
		// TODO Auto-generated constructor stub
	}

}
