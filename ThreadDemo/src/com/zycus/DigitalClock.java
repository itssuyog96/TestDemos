package com.zycus;

import java.util.Date;

public class DigitalClock implements Runnable {

	@Override
	public void run() {
		while (true) {
			Date dt = new Date();
			try {
				System.out.println("Time: " + dt.toString());
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("Thread interrupted!");
			}
		}

	}

}
