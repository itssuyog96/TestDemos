package demo1;

public class Employeex {

	private String firstName, lastName;
	public String designation;
	
	public Employeex(){
		this.firstName = "unknown";
		this.lastName = "unknown";
		
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void print(){
		System.out.println("Employee Name: "+firstName+" "+lastName);
	}
}
