package com.zycus;

public class Account {
	private long accNo;
	private int branchCode;
	protected double balance;

	public Account(long accNo, int branchCode, double balance) {
		super();
		this.accNo = accNo;
		this.branchCode = branchCode;
		this.balance = balance;
	}
}
