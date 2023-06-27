package com.wh.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bid")
public class Bid extends Order {

	public Bid() {
		// TODO Auto-generated constructor stub
	}

	public Bid(double price, User user, OrderBook code) {
		super(price, user, code);
		// TODO Auto-generated constructor stub
	}

}
