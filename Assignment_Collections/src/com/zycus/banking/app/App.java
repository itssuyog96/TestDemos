package com.zycus.banking.app;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;

import com.zycus.banking.service.Transaction;
import com.zycus.banking.util.Account;
import com.zycus.banking.util.BranchSet;
import com.zycus.banking.util.accountType;
import com.zycus.banking.util.status;

public class App {

	public static void main(String[] args) {

		// Create a branch using Map
		// Branch branch = new Branch();

		// Create a branch using Set
		BranchSet branch = new BranchSet();

		// Add accounts to that branch
		branch.openNewAccount(accountType.SAVINGS, 1000, "Iron Man");
		branch.openNewAccount(accountType.SAVINGS, 25008, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 3700, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 1200, "Captain America");
		branch.openNewAccount(accountType.SAVINGS, 15000, "SpiderMan");
		branch.openNewAccount(accountType.CURRENT, 20000, "Hulk    ");
		branch.openNewAccount(accountType.CURRENT, 14030, "Iron Man");
		branch.openNewAccount(accountType.CURRENT, 1760, "Deadpool");
		branch.openNewAccount(accountType.SAVINGS, 23506, "AntMan   ");
		branch.openNewAccount(accountType.SAVINGS, 670034, "Groot   ");

		// Create Transaction
		Transaction transaction = new Transaction(branch);

		// withdraws
		transaction.withdraw(1103, 1289);
		transaction.withdraw(1107, 2876);

		// deposits
		transaction.deposit(1104, 5000);
		transaction.deposit(1109, 4500);

		// transfers
		transaction.transfer(1102, 1173, 1000);
		transaction.transfer(1107, 1106, 10000);

		// Close Accounts
		branch.closeAccount(1105);
		branch.closeAccount(1103);
		branch.closeAccount(1107);
		branch.closeAccount(1109);

		// transfer after account closed
		// transaction.transfer(1107, 1106, 10000);

		out.println("accountNumber\tbranchCode\t\taccountHolder\t\taccountType\t\tbalance\t\t\tstatus");

		List<Account> accounts = branch.getAll();
		out.println("------------All Accounts----------");
		printAll(accounts);

		// Ascending Sort
		accounts.sort((o1, o2) -> (int) (o1.getBalance() - o2.getBalance()));

		out.println("------------Sorted (ASC) By balance Accounts----------");
		printAll(accounts);

		// Descending Sort
		accounts.sort((o1, o2) -> (int) (o2.getBalance() - o1.getBalance()));

		out.println("------------Sorted (DESC) By balance Accounts----------");
		printAll(accounts);

		// Sort by account number
		accounts.sort((o1, o2) -> (int) (o1.getAccountNumber() - o2.getAccountNumber()));

		out.println("------------Sorted By Account Number | Accounts----------");
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
			if (account.getAccountStatus() == status.ACTIVE)
				out.println(account);
			else
				err.println(account);
		}
	}

}
