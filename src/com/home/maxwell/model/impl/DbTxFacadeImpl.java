package com.home.maxwell.model.impl;

import java.util.List;

import com.home.maxwell.dao.DeptDao;
import com.home.maxwell.dao.EmpDao;
import com.home.maxwell.domain.Dept;
import com.home.maxwell.domain.Emp;
import com.home.maxwell.model.DbTxFacade;

public class DbTxFacadeImpl implements DbTxFacade{
	protected DeptDao deptDao;
	protected EmpDao empDao;
	
	public Emp queryEmpSalary(int empid) {
		Emp emp = empDao.queryEmp(empid);
		return emp;
	}

	public void updateEmpSalary(Emp emp) {
		empDao.updateEmpSalary(emp);
		System.out.println("UpdateEmpSalary Done.");
	}
	
	
	public void doTxRun1() {
		Dept dept = new Dept();
		dept.setDeptId(3);
		dept.setDeptName("Lenovo");
		dept.setAddress("ChuShou East Road");
		
		Emp emp = new Emp();
		emp.setEmpId(3);
		emp.setName("John");
		emp.setSalary(45000);
		
		deptDao.insertDept(dept);
		empDao.insertEmp(emp);
	}

	public void insertEmp(Emp emp) {
		empDao.insertEmp(emp);
	}
	
	public List<Emp> getAllEmp() {
		return empDao.getAllEmp();
	}
	
	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
}
