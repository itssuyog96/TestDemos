package demo1;

public class PartTimeEmployee extends Employee {
	private int timeShift;
	private float remuneration;
	
	public PartTimeEmployee(String firstName, String lastName, int age, int empId, String designation, int timeShift,
			float remuneration) {
		super(firstName, lastName, age, empId, designation);
		this.timeShift = timeShift;
		this.remuneration = remuneration;
	}
}
