package demo1;

import static java.lang.System.err;
import static java.lang.System.out;

public class TestException1 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int x = calc.calcDiv(10, 0);
		out.println("Result: " + x);
	}

}

class Calculator {
	public int calcDiv(int n1, int n2) {
		try {
			return n1 / n2;
		} catch (ArithmeticException e) {
			// e.printStackTrace();
			err.println("Error occured!!");
			return 0;
		}
	}
}
