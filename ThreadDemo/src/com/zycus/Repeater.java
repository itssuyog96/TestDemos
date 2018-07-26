package com.zycus;

public class Repeater implements Runnable {

	private String message;

	public Repeater(String message) {
		this.message = message;

	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 50; i++) {
			System.out.println(name + ": " + message);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " ended");

	}

}
