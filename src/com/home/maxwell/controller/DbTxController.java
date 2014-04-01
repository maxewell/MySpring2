package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.home.maxwell.domain.Emp;
import com.home.maxwell.model.DbTxFacade;

public class DbTxController extends ApctlController{
	protected DbTxFacade dbTxFacade;
	
	public ModelAndView onRunDemo(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletRequestBindingException{
		//if request has not empId info, it will throw bindingException 
		Integer empid = ServletRequestUtils.getRequiredIntParameter(req, "empId");
		String uno = (String)WebUtils.getSessionAttribute(req, "UNO");
		if (uno == null){
			//...
		}
		
		WebUtils.setSessionAttribute(req, "WORKUNO", uno);
		
		
		return null;
	}
	
	public ModelAndView onDbTxRun1(HttpServletRequest req, HttpServletResponse resp, HttpSession session){
		this.dbTxFacade.doTxRun1();
		
		return new ModelAndView("DbTxRun1");
	}

	public ModelAndView onInput(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletRequestBindingException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Emp> emplist = this.dbTxFacade.getAllEmp();
		map.put("dataList", emplist);
		
		Emp emp = new Emp();
		emp.setName("Perter");
		emp.setSalary(100000F);
		map.put("command", emp);
		
		return new ModelAndView("dbTxInput", map);
	}
	
	public ModelAndView onInsertEmpSal(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Emp emp){
		this.dbTxFacade.insertEmp(emp);
	
		Map<String, Object> map = new HashMap<String, Object>();
		List<Emp> emplist = this.dbTxFacade.getAllEmp();
		map.put("dataList", emplist);
		
		Emp newemp = new Emp();
		newemp.setName("Perter");
		newemp.setSalary(100000F);
		map.put("command", newemp);
		
		return new ModelAndView("dbTxInput", map);
	}
	
	public ModelAndView onUpdateEmpSal(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Emp emp){
		this.dbTxFacade.updateEmpSalary(emp);
		Emp newemp = this.dbTxFacade.queryEmpSalary(emp.getEmpId());
		
		return new ModelAndView("dbTxQuery",  "command", newemp);
	}
	
	public ModelAndView onQueryEmpSal(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletRequestBindingException{
		Integer empid = ServletRequestUtils.getRequiredIntParameter(req, "empId");
		Emp emp = this.dbTxFacade.queryEmpSalary(empid);
		
		return new ModelAndView("dbTxQuery", "command", emp);
	}
	
	public DbTxFacade getDbTxFacade() {
		return dbTxFacade;
	}

	public void setDbTxFacade(DbTxFacade dbTxFacade) {
		this.dbTxFacade = dbTxFacade;
	}
}
