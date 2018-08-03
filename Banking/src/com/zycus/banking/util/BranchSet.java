package com.zycus.banking.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import com.zycus.banking.Customer;

public class BranchSet extends Branch {
	private Set<Account> allAccounts = new HashSet<>();
	private static int ACC_NO_GENERATOR = 1101;
	private static int BRANCH_CODE_GEN = 910;

	public BranchSet() {
		BRANCH_CODE_GEN++;
	}
	
	public BranchSet(int branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public void openNewAccount(accountType accountType, float balance, Customer accountHolder) {
		Account account = new Account(ACC_NO_GENERATOR++, accountHolder, accountType, balance);
		account.setBranchCode(BRANCH_CODE_GEN);

		allAccounts.add(account);
	}

	public Account getAccount(int accountNo) {
		try {
			return allAccounts.stream().filter((x) -> x.getAccountNumber() == accountNo).findFirst().get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void closeAccount(int accountNo) {
		try {
			this.getAccount(accountNo).setAccountStatus(status.CLOSED);
		} catch (NullPointerException e) {
			System.err.println("Account does not exists");
		}
	}

	public List<Account> getAll() {
		return new LinkedList<Account>(allAccounts);
	}

	public List<Account> findByAccountHolder(String name) {
		return allAccounts.stream().filter((x) -> x.getAccountHolder().getFirstName().equalsIgnoreCase(name.trim()))
				.collect(Collectors.toList());
	}

}
