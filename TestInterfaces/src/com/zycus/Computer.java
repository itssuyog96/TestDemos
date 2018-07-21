package com.zycus;

public class Computer {
	private Display primaryDisplay;
	private Storage primaryStorage;

	public static void main(String args[]) {
		Computer comp = new Computer();
		comp.primaryDisplay = new Projector();

		// Anonymous Class
		comp.primaryStorage = new Storage() {

			@Override
			public void read() {
				System.out.println("Reading data");

			}

			@Override
			public void write() {
				System.out.println("Writing data");

			}

		};

		comp.primaryStorage.read();
		comp.primaryDisplay.draw();
	}
}
