package com.zycus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// generateFile("test1.txt", 50);
		// generateFile("test2.txt", 300);
		// generateFile("test3.txt", 10000);

		CounterLock obj = new CounterLock();

		List<Thread> threadList = new ArrayList<>();
		int threadCount = 0;

		for (int i = 0; i < 3; i++) {
			threadList.add(new Thread(new DataHolder("test" + (i + 1) + ".txt", obj)));
		}

		for (Thread t : threadList) {
			t.start();
		}

		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		new Thread(new Sorter(obj, threadList)).start();

	}

	public static void generateFile(String fileName, int fileSize) {
		Random rand = new Random();
		try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < fileSize - 1; i++) {
				out.write(rand.nextInt(fileSize) + "\n");
			}
			out.write(new Integer(rand.nextInt(fileSize)).toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
