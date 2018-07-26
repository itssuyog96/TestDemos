package com.zycus;

public class Main1 {

	public static void main(String[] args) {
		DigitalClock clock = new DigitalClock();

		Thread t = new Thread(clock);
		System.out.println("About to start a new thread:");

		t.start();

		System.out.println("Number of active threads " + Thread.activeCount());

	}

}
