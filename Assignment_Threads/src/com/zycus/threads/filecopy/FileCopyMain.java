package com.zycus.threads.filecopy;

public class FileCopyMain {

	public static void main(String[] args) {

		FileCopy fc = new FileCopy("C:\\Users\\suyog.gadhave\\Downloads\\Wildlife.wmv",
				"C:\\Users\\suyog.gadhave\\Downloads\\copyPath");

		Thread t = new Thread(fc);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
