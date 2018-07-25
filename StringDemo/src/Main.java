import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Mahendra");
		buffer.insert(0, "Mr ").append(" ").append("Shinde");
		System.out.println(buffer.toString());

		StringTokenizer tokenizer = new StringTokenizer("The quick brown fox jumps,over the.lazy dog", ",\n\r ");

		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

	}

}
