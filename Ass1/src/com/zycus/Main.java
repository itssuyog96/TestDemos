package com.zycus;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) throws TransactionDeclinedException {
		SavingAccount acc1 = new SavingAccount(1001, 316, 33000);
		SalaryAccount acc2 = new SalaryAccount(1002, 914, 20000);

		acc1.withdraw(1000);
		out.println(acc1);

		acc2.deposit(1200);
		out.println(acc2);

		acc2.withdraw(50000);

	}

}
