package com.zycus.threads.stack;

public class Main {

	public static void main(String args[]) {

		Thread t1 = new Thread(new Producer());
		Thread t2 = new Thread(new Consumer());

		t1.start();
		t2.start();

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {

		}

		System.exit(0);

	}
}
