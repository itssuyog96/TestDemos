package com.zycus;

public class CounterLock {

	private int count = 0;

	CounterLock() {

	}

	public void increment() {
		count++;
	}

	public void anotify() {

		count--;
		if (count == 0)
			this.notifyAll();

	}

	public void await() {

		if (count > 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
