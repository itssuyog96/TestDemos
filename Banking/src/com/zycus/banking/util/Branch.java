package com.zycus.banking.util;

import java.util.List;

import com.zycus.banking.Customer;

public abstract class Branch {
	protected int branchCode;
	protected String bankCode;

	public Branch() {
		// Empty constructor to initialize as a superclass;
	}

	public Branch(String bankCode, int branchCode) {
		this.bankCode = bankCode;
		this.branchCode = branchCode;
	}

	public abstract void openNewAccount(accountType accountType, float balance, Customer accountHolder);

	public abstract Account getAccount(int accountNo);

	public abstract void closeAccount(int accountNo);

	public abstract List<Account> getAll();

	public int getBranchCode() {
		return this.branchCode;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	@Override
	public String toString() {
		return branchCode + "";
	}

}
