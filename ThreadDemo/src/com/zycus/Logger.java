package com.zycus;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Stack;

public class Logger implements Runnable {
	private Stack<String> stack = new Stack<>();
	private boolean doStop = false;
	private OutputStream out;

	public Logger(OutputStream out) {
		this.out = out;
	}

	public void write(String message) {
		stack.add(message);
	}

	@Override
	public void run() {
		while (!doStop) {
			if (!stack.isEmpty()) {
				try {
					out.write(stack.pop().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void stop() {
		doStop = true;
	}

}
