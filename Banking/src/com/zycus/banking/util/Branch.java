package com.zycus.banking.util;

import java.util.List;

import com.zycus.banking.Customer;

public abstract class Branch {
	protected static int ACC_NO_GENERATOR = 1100;
	protected static int BRANCH_CODE_GEN = 910;
	protected int branchCode;
	
	public abstract void openNewAccount(accountType accountType, float balance, Customer accountHolder);

	public abstract Account getAccount(int accountNo);

	public abstract void closeAccount(int accountNo);

	public abstract List<Account> getAll();
}
