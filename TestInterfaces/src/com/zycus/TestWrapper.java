package com.zycus;

public class TestWrapper {

	public static void main(String[] args) {

		// // Boxing
		// Integer n = new Integer(100);
		// // Auto-boxing
		// n = 500;
		// System.out.println(n);
		//
		// // Unboxing
		// int x = n.intValue();
		// // Auto-unboxing
		// x = n;
		// System.out.println(x);
		//
		// System.out.println(Integer.toHexString(255));
		// System.out.println(Integer.toOctalString(255));
		// System.out.println(Integer.toBinaryString(255));

		Number[] num = { 1, 3F, 5L };

		Number avg = (num[0].floatValue() + (float) num[1] + num[2].floatValue()) / 3;
		System.out.println("Result: " + avg);

	}

}
