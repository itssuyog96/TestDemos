package com.zycus.app;

import com.zycus.models.Employee;

public class Main {

	public static void main(String[] args) {
		AppLogic2 logic = new AppLogic2();

		Employee[] emp = new Employee[3];
		emp[0] = new Employee("Rajiv", "Bhatia", "Assistant director", 52);
		emp[1] = new Employee("Twinkle", "Khanna", "Director", 47);
		emp[2] = new Employee("Dev", "Anand", "Manager", 92);

		logic.write(emp);

		for (Employee e : logic.read()) {
			if (e == null)
				break;
			System.out.println(e);
		}

	}

}
