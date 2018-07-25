import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App3 {

	private static final String DATA_FILE = "D:\\dataFile.txt";

	public static void main(String[] args) {

		write("Some message.");
		read();
	}

	static void write(String text) {

		try (FileWriter writer = new FileWriter(DATA_FILE, true)) {

			char[] buffer = text.toCharArray();
			writer.write(buffer);
			;
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void read() {

		try (FileReader reader = new FileReader(DATA_FILE)) {
			char[] buffer = new char[100];

			String str = "";

			int len = reader.read(buffer);
			while (len > 0) {
				str += new String(buffer, 0, len);
				len = reader.read(buffer);
			}

			System.out.println("Message: " + str);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
