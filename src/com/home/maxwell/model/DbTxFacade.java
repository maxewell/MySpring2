package com.home.maxwell.model;

import java.util.List;

import com.home.maxwell.domain.Emp;

public interface DbTxFacade {
	public void doTxRun1();
	public Emp queryEmpSalary(int empid);
	public void updateEmpSalary(Emp emp);
	public void insertEmp(Emp emp);
	public List<Emp> getAllEmp();
}
