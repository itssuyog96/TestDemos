package com.zycus;

public class Account {
	private int accountNo;
	private float balance;

	public Account(int accountNo, float balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	int getAccountNo() {
		return accountNo;
	}

	float getBalance() {
		return balance;
	}

	void setBalance(float temp) {
		this.balance = temp;
	}
}
