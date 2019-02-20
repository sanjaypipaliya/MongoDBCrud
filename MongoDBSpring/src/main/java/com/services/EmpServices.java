


package com.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.entity.Emp;

public interface EmpServices {
	
	public void insert(Emp emp);
	
	public List<Emp> getEmps();
	
	public Emp getEmpById(ObjectId objId);
	
	public void update(Emp emp);
	
	public void delete(ObjectId id);
}
