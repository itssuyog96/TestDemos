package com.zycus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHolder extends Sorter implements Runnable {
	private List<Integer> list = new ArrayList<Integer>();
	private String fileName;

	public DataHolder(String fileName) {
		this.fileName = fileName;
		super.addListStatusToSort();
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = in.readLine()) != null) {
				list.add(Integer.parseInt(line));
			}

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		list.sort((x, y) -> x.compareTo(y));

		super.updateStatus();

		super.addListToSort(list);

		System.out.println("\n\n" + fileName);
		for (int x : list) {
			System.out.print(x + ",");
		}

	}

	public List<Integer> getList() {
		return list;
	}

}
