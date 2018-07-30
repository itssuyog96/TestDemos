package com.zycus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// generateFile("test1.txt", 5000);
		// generateFile("test2.txt", 3000);
		// generateFile("test3.txt", 10000);

		new Thread(new DataHolder("test1.txt")).run();
		new Thread(new DataHolder("test2.txt")).run();
		new Thread(new DataHolder("test3.txt")).run();

		new Thread(new Sorter()).run();
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
