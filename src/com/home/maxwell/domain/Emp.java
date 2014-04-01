package com.home.maxwell.domain;

public class Emp {
	protected int empId;
	protected String name;
	protected int deptId;
	protected float salary;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getEmpIdStr() {
		String rs = null;
		if (this.empId > 0){
			rs = String.valueOf(this.empId);
		}
		return rs;
	}
	public String getDeptIdStr() {
		String rs = null;
		if (this.deptId > 0){
			rs = String.valueOf(this.deptId);
		}
		return rs;
	}
	public String getSalaryStr() {
		String rs = null;
		if (this.salary > 0){
			rs = String.valueOf(this.salary);
		}
		return rs;
		
	}
}
