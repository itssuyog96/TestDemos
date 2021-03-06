package com.zycus;

public class SavingAccount extends Account implements BankTransaction {

	public static final int WITHDRAWAL_LIMIT = 10000;
	public static final int MIN_BALANCE = 1000;

	public SavingAccount(long accNo, int branchCode, double balance) {
		super(accNo, branchCode, balance);
	}

	@Override
	public void withdraw(double amt) {
		if (amt >= WITHDRAWAL_LIMIT) {
			throw new TransactionDeclinedException("Amount greater than withdrawal limit");
		}

		if (amt < 0) {
			throw new TransactionDeclinedException("Withdrawal amount cannot be negative");
		}

		double temp = balance - amt;

		if (temp < MIN_BALANCE) {
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
		return "SavingAccount [balance=" + balance + "]";
	}

}
