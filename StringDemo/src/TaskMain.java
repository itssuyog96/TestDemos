import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TaskMain {

	static List<String> tokenList = new LinkedList<>();

	public static void main(String[] args) {
		final String DATA_PATH = "D:\\sample_text.txt";
		StringBuilder builder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH))) {

			String chunk = br.readLine();
			while (chunk != null) {
				builder.append(chunk).append("\n");
				// System.out.println(chunk + "\n");
				chunk = br.readLine();
			}

			StringTokenizer tokenizer = new StringTokenizer(builder.toString(), ".;,\n\t<>/+\r: ");

			while (tokenizer.hasMoreTokens()) {
				tokenList.add(tokenizer.nextToken());
			}

			System.out.println(countWord("text"));

			// for (String s : singleWord("text")) {
			// System.out.println(s);
			// }

			System.out.println(singleWord("text").size());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> singleWord(String word) {
		return tokenList.stream().filter((x) -> x.equalsIgnoreCase(word)).collect(Collectors.toList());
	}

	private static long countWord(String word) {
		return tokenList.stream().filter((x) -> x.equalsIgnoreCase(word)).count();
	}

}
