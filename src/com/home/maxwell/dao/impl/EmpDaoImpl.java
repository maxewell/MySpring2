package com.home.maxwell.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.EmpDao;
import com.home.maxwell.domain.Emp;

public class EmpDaoImpl extends SqlMapClientDaoSupport implements EmpDao{

	public void insertEmp(Emp emp) {
		getSqlMapClientTemplate().insert("Emp.insertEmp", emp);
	}

	public float queryEmpSalary(int empid) {
		Float sal = (Float)getSqlMapClientTemplate().queryForObject("Emp.queryEmpSalary", empid);
		return sal.floatValue();
	}

	public void updateEmpSalary(Emp emp) {
		getSqlMapClientTemplate().update("Emp.updateEmpSalary", emp);
		System.out.println("EmpDaoImpl:updateEmpSalary");
	}

	public List<Emp> getAllEmp() {
		return (List<Emp>)getSqlMapClientTemplate().queryForList("Emp.getAllEmp");
	}

	public Emp queryEmp(int empid) {
		return (Emp)getSqlMapClientTemplate().queryForObject("Emp.queryEmp", new Integer(empid));
	}

}
