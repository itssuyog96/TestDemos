package com.zycus.banking.service;

public interface TransactionInterface {
	public boolean withdraw(int accountNumber, float amount);

	public boolean deposit(int accountNumber, float amount);

	public void transfer(int sourceAccountNumber, int destinationAccountNumber, float amount);

}
