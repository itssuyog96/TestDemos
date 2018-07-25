package demo1;

public class TestException4 {

	public static void main(String[] args) {

		int sum = 0;
		int n = 0;

		for (String s : args) {
			try {
				n = Integer.parseInt(s);
				sum += n;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Sum: " + sum);

	}

}
