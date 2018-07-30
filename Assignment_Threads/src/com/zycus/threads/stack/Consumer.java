package com.zycus.threads.stack;

public class Consumer extends MyStack implements Runnable {

	public static boolean toRun = true;
	public static int i = 1;
	private int MAX = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (stack) {
				if (stack.isEmpty())
					try {
						stack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else {
					System.out.println((i++) + " : " + stack.pop() + " | Size : " + stack.size());
					if (stack.size() == MAX - 1)
						stack.notify();
				}
			}
		}
	}

}
