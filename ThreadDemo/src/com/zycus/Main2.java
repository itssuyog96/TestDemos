package com.zycus;

public class Main2 {

	public static void main(String[] args) {
		Repeater a = new Repeater("India");
		Repeater b = new Repeater("Australia");

		// System.out.println(Thread.currentThread().getName());

		Thread t1 = new Thread(a);
		// t1.setDaemon(true);
		t1.start();
		new Thread(b).start();

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("MAIN THREAD");
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " ended!");

	}

}
