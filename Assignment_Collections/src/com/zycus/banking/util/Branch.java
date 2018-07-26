package com.zycus.banking.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Branch extends BranchParent {

	private Map<Integer, Account> allAccounts = new HashMap<>();

	public Branch() {
		BRANCH_CODE_GEN++;
	}

	public void openNewAccount(com.zycus.banking.util.accountType accountType, float balance, String accountHolder) {
		Account account = new Account(++ACC_NO_GENERATOR, accountHolder, accountType, balance);
		account.setBranchCode(BRANCH_CODE_GEN);
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
		return allAccounts.values().stream().filter((x) -> x.getAccountHolder().equalsIgnoreCase(name.trim()))
				.collect(Collectors.toSet());
	}

}
