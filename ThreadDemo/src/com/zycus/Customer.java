package com.zycus;

import java.util.concurrent.atomic.AtomicBoolean;

public class Customer {
	private Account account;
	private String name;

	private static final int MIN_BAL = 1000;

	public Customer(Account account, String name) {
		super();
		this.account = account;
		this.name = name;
	}

	public void withdraw(float amt) {
		delay();
		synchronized (account) {
			float temp = account.getBalance() - amt;
			if (temp > MIN_BAL) {
				System.out.println("Hi " + name + ", Withdrawal was successful!");
				account.setBalance(temp);
			} else {
				System.out.println("Hi " + name + ", Withdrawal failed!");
			}
		}
	}

	private static void delay() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	AtomicBoolean a;
}
