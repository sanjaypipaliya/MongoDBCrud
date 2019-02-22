package com.controller;




import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Emp;

import com.services.EmpServices;

@Controller
@RequestMapping("/crud")
public class CrudController {

	@Autowired
	private EmpServices empSerivces;
	
	@ModelAttribute("emp")
	public Emp constuct() {
		return new Emp();
	}
	
	@RequestMapping("/insert")
	public String insert() {
		return "crud/insert";
	}

	@RequestMapping(value ="/insertData" , method = RequestMethod.POST)
	public String insertData(@ModelAttribute("emp") Emp emp) {
		try {
		empSerivces.insert(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/crud/showEmps";
	}

	
	@RequestMapping("/showEmps")
	public ModelAndView showEmps() {
		return new ModelAndView("/crud/showdata","empList",empSerivces.getEmps());
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") ObjectId objId) {
		return new ModelAndView("/crud/update","emp",empSerivces.getEmpById(objId));
	}
	
	@RequestMapping("/updateData")
	public String updateData(@ModelAttribute("emp") Emp emp) {
		try {
			empSerivces.update(emp);
			return "redirect:/crud/showEmps";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}		
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") ObjectId objId) {
		empSerivces.delete(objId);
		return "redirect:/crud/showEmps";
	}

}
