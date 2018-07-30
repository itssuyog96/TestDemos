package com.zycus.threads.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy implements Runnable {

	private Path sourcePath;
	private Path destinationPath;
	private final static int BYTE_IO_LENGTH = 100;
	private FileInputStream fin;
	private FileOutputStream fout;

	public FileCopy(String sourcePath, String destinationPath) {
		super();
		try {
			this.sourcePath = Paths.get(sourcePath);
			this.destinationPath = Paths
					.get(destinationPath + System.getProperty("file.separator") + this.sourcePath.getFileName());

			System.out.println("Source :" + this.sourcePath + "\nDestination:" + this.destinationPath);

			if (Files.exists(this.destinationPath)) {
				System.out.println("File already exists!");

				System.exit(0);
			} else {
				fin = new FileInputStream(this.sourcePath.toFile());
				fout = new FileOutputStream(this.destinationPath.toFile(), true);
			}

		} catch (InvalidPathException | FileNotFoundException e) {
			System.out.println("Invalid File Path");
			System.exit(0);
		}

	}

	@Override
	public void run() {

		byte[] bytes = new byte[BYTE_IO_LENGTH];
		int len;

		try {
			while ((len = fin.read(bytes)) != -1) {
				// Send for writing
				write(bytes, len);

			}
		} catch (IOException e) {
			System.err.println("Error occured while reading data");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void write(byte[] bytes, int len) {
		try {
			fout.write(bytes, 0, len);
		} catch (IOException e) {
			System.err.println("Error occured while writing data");
			e.printStackTrace();
			System.exit(2);
		}
	}

}
