package com.zycus;

import java.util.ArrayList;
import java.util.List;

public class Sorter implements Runnable {

	private static final int MAX_LISTS = 10;
	private static List<Boolean> taskRunnerStatusDone = new ArrayList<>();
	protected static List<Integer> finalList = new ArrayList<>();
	// protected static List<Integer> tempLists[MAX_LISTS];
	private static boolean sorted = false;
	private static int index = 0;
	private static int listsIndex = 0;
	private List<Thread> threadList;

	private CounterLock obj;

	Sorter(CounterLock obj, List<Thread> threadList) {
		this.obj = obj;
		this.threadList = threadList;

	}

	protected static void addListStatusToSort() {
		taskRunnerStatusDone.add(false);
	}

	@Override
	public void run() {

		// try {
		// for (Thread t : threadList) {
		// t.join();
		// }
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		try {
			obj.await();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("\nReady");
		// Ready to carry out final merge sort

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

	// protected static void addListToSort(List<Integer> list) {
	// tempLists[listsIndex++] = new ArrayList<Integer>(list);
	// }

	protected static void updateStatus() {

		taskRunnerStatusDone.set(index++, true);
	}

}
