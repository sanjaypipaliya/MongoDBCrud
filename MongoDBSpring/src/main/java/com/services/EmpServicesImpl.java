package com.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpDAO;
import com.entity.Emp;

@Service
public class EmpServicesImpl implements EmpServices{

	@Autowired
	private EmpDAO empDAO;
	
	@Transactional
	public void insert(Emp emp) {
		empDAO.insert(emp);
		
	}

	public List<Emp> getEmps() {
		
		return empDAO.getEmps();
	}

	public Emp getEmpById(ObjectId objId) {
		return empDAO.getEmpById(objId);
	}

	public void update(Emp emp) {
		empDAO.update(emp);		
	}

	public void delete(ObjectId id) {
		empDAO.delete(id);
	}

}
