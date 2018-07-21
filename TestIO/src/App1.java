import java.io.IOException;

public class App1 {

	public static void main(String[] args) {

		byte[] buffer = new byte[100];

		try {
			System.out.print("Enter your name :");

			int len = System.in.read(buffer);

			System.out.println("You have enterd: " + len + " bytes.");

			String name = new String(buffer, 0, len);
			System.out.println("Name: " + name);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
