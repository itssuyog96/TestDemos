package com.zycus.threads.stack;

import java.util.Random;

public class Producer extends MyStack implements Runnable {
	private StringBuilder stringBuilder;
	private Random rand;
	private int MAX = 1000;
	public static int i = 1;

	Producer() {
		stringBuilder = new StringBuilder();
		rand = new Random();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (stack) {
				if (stack.size() == MAX)
					try {
						stack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else {
					stack.push(generateRandomString());

					if (stack.size() == 1)
						stack.notify();
				}
			}
			System.out.println("Pushing " + Producer.i++);
		}
	}

	private String generateRandomString() {
		stringBuilder.delete(0, stringBuilder.length());
		for (int i = 0; i < 40; i++) {
			stringBuilder.append((char) (rand.nextInt(26) + 65));
		}
		return stringBuilder.toString();
	}

}
