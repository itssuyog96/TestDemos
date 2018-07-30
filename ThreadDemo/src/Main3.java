import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

import com.zycus.Logger;

public class Main3 {

	public static void main(String[] args) throws IOException {
		Logger log1 = new Logger(System.out);
		FileOutputStream fout = new FileOutputStream("D:\\data3.txt");
		Logger log2 = new Logger(fout);

		new Thread(log1).start();
		new Thread(log2).start();

		log1.write("Hello World");
		log1.write("Hello India");

		log2.write("Hello World");
		log2.write("Hello India");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log1.stop();
		log2.stop();
	}

	ReadWriteLock a;

}
