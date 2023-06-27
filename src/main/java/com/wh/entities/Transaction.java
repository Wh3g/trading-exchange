package com.wh.entities;

import jakarta.persistence.Entity;

@Entity
public class Transaction {

	private Ask ask;
	private Bid bid;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Ask ask, Bid bid) {
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

}
