import java.io.Console;

public class App2 {

	public static void main(String[] args) {
		Console console = System.console();
		console.printf("Enter your password: ");
		String pass = new String(console.readPassword());
		console.printf("You entered: %20s", pass);

	}

}
