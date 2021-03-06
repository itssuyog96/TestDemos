package com.zycus.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestTxtFile {

	public static void main(String[] args) {
		System.out.println("Reading file through channel...");
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\dataFile.txt");
			FileChannel in = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(100);
			int readBytes = in.read(buffer);
			while (readBytes != -1) {
				// flip to READ mode
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}
				buffer.clear();
				readBytes = in.read(buffer);
			}

			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
