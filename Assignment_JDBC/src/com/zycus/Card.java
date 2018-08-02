package com.zycus;

import java.sql.Date;

public class Card {
	private long id;
	private Date expiry;
	private long customerId;
	private float balance;
	private int creditLimit;

	public Card(long id, Date expiry, long customerId, float balance, int creditLimit) {
		super();
		this.id = id;
		this.expiry = expiry;
		this.customerId = customerId;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}

	long getId() {
		return id;
	}

	void setId(long id) {
		this.id = id;
	}

	Date getExpiry() {
		return expiry;
	}

	void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	long getCustomerId() {
		return customerId;
	}

	void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	float getBalance() {
		return balance;
	}

	void setBalance(float balance) {
		this.balance = balance;
	}

	int getCreditLimit() {
		return creditLimit;
	}

	void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", expiry=" + expiry + ", customerId=" + customerId + ", balance=" + balance
				+ ", creditLimit=" + creditLimit + "]";
	}

}
