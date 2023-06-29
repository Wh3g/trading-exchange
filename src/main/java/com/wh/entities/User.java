package com.wh.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String email;
	@Column(unique=true)
	private String username;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	@OneToMany(mappedBy="user")
	private List<Transaction> transactions;
	
	public User() {
		super();
		// Default Constructor
	}

	public User(String email, String username, String password, List<Order> orders, List<Transaction> transactions) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.orders = orders;
		this.transactions = transactions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
