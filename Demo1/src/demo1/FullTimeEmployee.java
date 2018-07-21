package demo1;

public class FullTimeEmployee extends Employee {
	private float salary;
	private float providentFund;
	
	public FullTimeEmployee(String firstName, String lastName, int age, int empId, String designation, float salary,
			float providentFund) {
		super(firstName, lastName, age, empId, designation);
		this.salary = salary;
		this.providentFund = providentFund;
	}
}
