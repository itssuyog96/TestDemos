package com.zycus;

public class Employee {
	private int empid;
	private String ename;
	private float sal;
	private int deptid;

	public Employee() {
		super();
	}

	public Employee(int empid, String ename, float sal, int deptid) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
		this.deptid = deptid;
	}

	int getEmpid() {
		return empid;
	}

	void setEmpid(int empid) {
		this.empid = empid;
	}

	String getEname() {
		return ename;
	}

	void setEname(String ename) {
		this.ename = ename;
	}

	float getSal() {
		return sal;
	}

	void setSal(float sal) {
		this.sal = sal;
	}

	int getDeptid() {
		return deptid;
	}

	void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + ", deptid=" + deptid + "]";
	}

}
