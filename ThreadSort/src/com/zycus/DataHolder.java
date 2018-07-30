package com.zycus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHolder implements Runnable {
	private List<Integer> list = new ArrayList<Integer>();
	private String fileName;

	private CounterLock obj;

	public DataHolder(String fileName, CounterLock obj) {
		this.fileName = fileName;
		Sorter.addListStatusToSort();

		obj.increment();
		this.obj = obj;
		// obj.()
	}

	@Override
	public void run() {

		/*
		 * try { if ("test1.txt".equalsIgnoreCase(fileName)) Thread.sleep(15000); if
		 * ("test2.txt".equalsIgnoreCase(fileName)) Thread.sleep(10000); if
		 * ("test3.txt".equalsIgnoreCase(fileName)) Thread.sleep(5000); } catch
		 * (InterruptedException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = in.readLine()) != null) {
				list.add(Integer.parseInt(line));
			}

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		list.sort((x, y) -> x.compareTo(y));

		Sorter.updateStatus();

		// super.addListToSort(list);

		System.out.println("\n\n" + fileName);
		for (int x : list) {
			System.out.print(x + ",");
		}

		try {
			obj.anotify();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<Integer> getList() {
		return list;
	}

}
