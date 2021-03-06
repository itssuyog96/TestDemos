package com.zycus;

public class SalaryAccount extends Account implements BankTransaction {

	public SalaryAccount(long accNo, int branchCode, double balance) {
		super(accNo, branchCode, balance);
	}

	@Override
	public void withdraw(double amt) {

		if (amt < 0) {
			throw new TransactionDeclinedException("Withdrawal amount cannot be negative");
		}

		double temp = balance - amt;
		if (temp < 0) {
			throw new TransactionDeclinedException("No sufficient balance");
		}

		this.balance = temp;
	}

	@Override
	public void deposit(double amt) {
		if (amt < 0) {
			throw new TransactionDeclinedException("Deposit amount cannot be negative");
		}

		this.balance += amt;

	}

	@Override
	public String toString() {
		return "SalaryAccount [balance=" + balance + "]";
	}

}
