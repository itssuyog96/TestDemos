package com.zycus.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.zycus.models.Employee;

public class AppLogic {
	private static final String DATA_PATH = "D:\\data\\emps.txt";
	private static final String sep = ", ";

	public Employee[] read() {
		Employee[] temp = new Employee[100];
		int i = 0;
		try (Scanner br = new Scanner(new File(DATA_PATH))) {
			String line = null;
			while (br.hasNextLine()) {
				line = br.nextLine();
				String[] fields = line.split(sep);
				Employee e = convert(fields);
				temp[i++] = e;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return temp;
	}

	private Employee convert(String[] values) {

		String fname = values[0];
		String lname = values[1];
		String tempAge = values[2];
		int age = Integer.parseInt(tempAge);
		String design = values[3];

		return new Employee(fname, lname, design, age);
	}

	public void write(Employee[] emps) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_PATH))) {
			for (Employee e : emps) {
				bw.write(e.getFirstName() + sep + e.getLastName() + sep + e.getAge() + sep + e.getDesignation() + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
