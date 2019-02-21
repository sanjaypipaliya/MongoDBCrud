package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Emp;
import com.services.EmpServices;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@RestController
@RequestMapping("/rest")
public class RestFullController {

	@Autowired
	private EmpServices empSerivces;

	@ResponseBody
	@RequestMapping(value = "/getemps")
	public List<Emp> getyEMps() {
		return empSerivces.getEmps();
	}

	@ResponseBody
	@PostMapping(value = "/addemp", consumes = "application/json")
	public String addEmp(@RequestBody Emp emp) throws ParseException {
		try {
			empSerivces.insert(emp);
			return "Data inserted";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@ResponseBody
	@PostMapping(value="/updateemp",consumes="application/json")
	public String updateEmp(@RequestBody Emp emp) {
		try {
			empSerivces.update(emp);
			return "Data updated";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@ResponseBody
	@PostMapping(value="/deleteemp",consumes="application/json")
	public String deleteEmp(@RequestBody Emp emp) {
		try {
			empSerivces.delete(emp.getEmpId());
			return "Data deleted";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

}
