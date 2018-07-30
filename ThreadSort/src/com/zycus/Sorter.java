package com.zycus;

import java.util.ArrayList;
import java.util.List;

public class Sorter implements Runnable {

	private static final int MAX_LISTS = 10;
	private static List<Boolean> taskRunnerStatusDone = new ArrayList<>();
	protected static List<Integer> finalList = new ArrayList<>();
	protected static List<Integer> tempLists[];
	private static boolean sorted = false;
	private static int index = 0;
	private static int listsIndex = 0;

	protected static void addListStatusToSort() {
		taskRunnerStatusDone.add(false);
	}

	@Override
	public void run() {

		while (!sorted) {

			if (check()) {
				System.out.println("\nReady");
				// Ready to carry out final merge sort

				sort();

				sorted = true;
			} else {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	private static void sort() {
		int[] indexes = new int[listsIndex];

	}

	private static boolean check() {
		if (taskRunnerStatusDone.size() == 0)
			return false;
		for (boolean x : taskRunnerStatusDone) {
			if (!x)
				return false;
		}

		return true;
	}

	protected static void addListToSort(List<Integer> list) {
		tempLists[listsIndex++] = list;
	}

	protected static void updateStatus() {

		taskRunnerStatusDone.set(index++, true);
	}

}
