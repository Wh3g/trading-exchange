package com.wh.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name="ask")
	private Ask ask;
	
	@OneToOne
	@JoinColumn(name="bid")
	private Bid bid;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	private double price;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Ask ask, Bid bid, double price) {
		super();
		this.ask = ask;
		this.bid = bid;
	}

	public Ask getAsk() {
		return ask;
	}

	public void setAsk(Ask ask) {
		this.ask = ask;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
