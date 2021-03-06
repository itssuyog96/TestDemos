package com.zycus.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.zycus.models.Employee;

public class AppLogic2 {
	private static final String DATA_PATH = "D:\\data\\emps.dat";

	public Employee[] read() {
		Employee[] temp = new Employee[100];
		int i = 0;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_PATH))) {
			Object obj = in.readObject();
			while (obj != null) {
				temp[i++] = (Employee) obj;
				obj = in.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
		}

		return temp;
	}

	public void write(Employee[] emps) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_PATH))) {
			for (Employee e : emps) {
				out.writeObject(e);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
