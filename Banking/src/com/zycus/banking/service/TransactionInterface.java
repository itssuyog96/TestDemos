package com.zycus.banking.service;

import com.zycus.banking.util.Branch;

public interface TransactionInterface {
	public boolean withdraw(Branch branch, int accountNumber, float amount);

	public boolean deposit(Branch branch, int accountNumber, float amount);

	public void transfer(Branch srcBranch, int sourceAccountNumber, Branch destBranch, int destinationAccountNumber, float amount);

}
