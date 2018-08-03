package com.zycus.banking.util;

import com.zycus.banking.Customer;

public class Account {
	private int accountNumber;
	private int branchCode;
	private Customer accountHolder;
	private accountType accountType;
	private float balance;
	private status status;

	Account(int accountNumber, Customer accountHolder, com.zycus.banking.util.accountType accountType, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.balance = balance;
		this.status = com.zycus.banking.util.status.ACTIVE;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public Customer getAccountHolder() {
		return accountHolder;
	}

	public accountType getAccountType() {
		return accountType;
	}

	public float getBalance() {
		return balance;
	}

	void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	void setAccountType(accountType accountType) {
		this.accountType = accountType;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	void setAccountStatus(status status) {
		this.status = status;
	}

	public status getAccountStatus() {
		return this.status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return accountNumber + "\t\t" + branchCode + "\t\t\t" + accountHolder + "\t\t" + accountType + "\t\t   "
				+ balance + "\t\t\t" + status;
	}

}
