package com.zycus.banking.app;

import static java.lang.System.out;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.zycus.banking.service.Transaction;
import com.zycus.banking.util.Account;
import com.zycus.banking.util.Branch;
import com.zycus.banking.util.accountType;
import com.zycus.banking.util.status;

public class App {

	public static void main(String[] args) {

		out.println("accountNumber\tbranchCode\t\taccountHolder\t\taccountType\t\tbalance\t\t\tstatus");

		// Create a branch using Map
		Branch branch = new Branch();

		// Create a branch using Set
		// BranchSet branch = new BranchSet();

		// Add accounts to that branch
		branch.openNewAccount(accountType.SAVINGS, 10000, "Iron Man");
		branch.openNewAccount(accountType.SAVINGS, 250089, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 17000, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 12000, "Captain America");
		branch.openNewAccount(accountType.SAVINGS, 150000, "SpiderMan");
		branch.openNewAccount(accountType.CURRENT, 200000, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 140304, "Iron Man");
		branch.openNewAccount(accountType.CURRENT, 17600, "Deadpool");
		branch.openNewAccount(accountType.SAVINGS, 235060, "AntMan   ");
		branch.openNewAccount(accountType.SAVINGS, 6700354, "Groot   ");

		// Create Transaction
		Transaction transaction = new Transaction(branch);

		// withdraws
		transaction.withdraw(1103, 1289);
		transaction.withdraw(1107, 23876);

		// deposits
		transaction.deposit(1104, 5000);
		transaction.deposit(1109, 4500);

		// transfers
		transaction.transfer(1102, 1103, 1000);
		transaction.transfer(1107, 1106, 10000);

		// Close Accounts
		branch.closeAccount(1105);
		branch.closeAccount(1103);
		branch.closeAccount(1107);
		branch.closeAccount(1109);

		// transfer after account closed
		// transaction.transfer(1107, 1106, 10000);

		List<Account> accounts = branch.getAll();
		out.println("------------All Accounts----------");
		printAll(accounts);

		// Ascending Sort
		accounts.sort(new Comparator<Account>() {

			@Override
			public int compare(Account o1, Account o2) {
				return (int) (o1.getBalance() - o2.getBalance());
			}

		});

		out.println("------------Sorted (ASC) By balance Accounts----------");
		printAll(accounts);

		// Descending Sort
		accounts.sort(new Comparator<Account>() {

			@Override
			public int compare(Account o1, Account o2) {
				return (int) (o2.getBalance() - o1.getBalance());
			}

		});

		out.println("------------Sorted (DESC) By balance Accounts----------");
		printAll(accounts);

		out.println("------------ACTIVE Accounts----------");
		printAll(accounts.stream().filter((x) -> x.getAccountStatus() == status.ACTIVE).collect(Collectors.toList()));

		out.println("------------CLOSED Accounts----------");
		printAll(accounts.stream().filter((x) -> x.getAccountStatus() == status.CLOSED).collect(Collectors.toList()));

		out.println("------------CLOSED Accounts && BAL > 5000----------");
		printAll(accounts.stream().filter((x) -> x.getAccountStatus() == status.CLOSED && x.getBalance() > 5000)
				.collect(Collectors.toList()));

	}

	private static void printAll(List<Account> accounts) {
		for (Account account : accounts) {
			out.println(account);
		}
	}

}
