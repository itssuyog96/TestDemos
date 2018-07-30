package com.zycus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);

		Repeater r1 = new Repeater("Hello India");
		Repeater r2 = new Repeater("Hello Mumbai");
		Repeater r3 = new Repeater("Hello Seepz");

		service.submit(r1);
		service.submit(r2);
		service.submit(r3);

		service.shutdown();

	}

}
