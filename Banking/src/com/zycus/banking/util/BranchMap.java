package com.zycus.banking.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import com.zycus.banking.Customer;

public class BranchMap extends Branch {

	private Map<Integer, Account> allAccounts = new HashMap<>();

	public BranchMap(String bankCode, int branchCode) {
		super(bankCode, branchCode);
	}

	@Override
	public void openNewAccount(accountType accountType, float balance, Customer accountHolder) {
		Account account = new Account(0, accountHolder, accountType, balance);
		account.setBranchCode(0);
		allAccounts.put(account.getAccountNumber(), account);

	}

	public Account getAccount(int accountNo) {

		return allAccounts.get(accountNo);

	}

	public void closeAccount(int accountNo) {
		try {
			allAccounts.get(accountNo).setAccountStatus(status.CLOSED);
		} catch (NoSuchElementException | NullPointerException e) {
			System.err.println("Account does not exists");
		}
	}

	public List<Account> getAll() {
		return new LinkedList<Account>(allAccounts.values());
	}

	public Set<Account> findByAccountHolder(String name) {
		return allAccounts.values().stream()
				.filter((x) -> x.getAccountHolder().getFirstName().equalsIgnoreCase(name.trim()))
				.collect(Collectors.toSet());
	}

}
