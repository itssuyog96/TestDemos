package com.zycus.banking.service;

import static java.lang.System.err;

import com.zycus.banking.util.Account;
import com.zycus.banking.util.Branch;
import com.zycus.banking.util.BranchSet;
import com.zycus.banking.util.status;

public class Transaction implements TransactionInterface {

	Object branch;

	private static final float MIN_BALANCE = 1000;

	public Transaction(Object branch) {
		super();
		this.branch = branch;

	}

	@Override
	public boolean withdraw(int accountNo, float amount) {
		Account account = getAccount(accountNo);

		if (checkAccount(account)) {
			float tempBalance = account.getBalance() - amount;
			if (tempBalance >= MIN_BALANCE) {
				account.setBalance(tempBalance);
				// out.println("Withdrew " + amount + " from AC no." + accountNo);
				return true;
			} else {
				err.println("Insufficient balance.");
			}
		}

		return false;

	}

	@Override
	public boolean deposit(int accountNo, float amount) {
		Account account = getAccount(accountNo);

		if (checkAccount(account)) {
			float tempBalance = account.getBalance() + amount;
			account.setBalance(tempBalance);
			// out.println("Deposited " + amount + " in AC no." + accountNo);
			return true;
		}

		return false;

	}

	@Override
	public void transfer(int sourceAccountNumber, int destinationAccountNumber, float amount) {
		if (withdraw(sourceAccountNumber, amount)) {
			if (!deposit(destinationAccountNumber, amount)) {
				err.println("Unable to deposit. Rolling back...");
				deposit(sourceAccountNumber, amount);
			}
		}
	}

	private static boolean checkAccount(Account account) {
		if (account != null)
			if (account.getAccountStatus() == status.ACTIVE) {
				return true;
			} else {
				err.println("Account is closed.");
				return false;
			}
		else
			err.println("Account does not exist.");
		return false;
	}

	private Account getAccount(int accountNo) {
		if (this.branch instanceof Branch) {
			return ((Branch) this.branch).getAccount(accountNo);
		} else {
			return ((BranchSet) this.branch).getAccount(accountNo);
		}

	}

}
