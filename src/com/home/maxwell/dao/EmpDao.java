package com.home.maxwell.dao;

import java.util.List;

import com.home.maxwell.domain.Emp;

public interface EmpDao {
	public void insertEmp(Emp emp);
	public float queryEmpSalary(int empid);
	public void updateEmpSalary(Emp emp);
	public List<Emp> getAllEmp();
	public Emp queryEmp(int empid);
}
