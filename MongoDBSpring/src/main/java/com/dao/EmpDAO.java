package com.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.entity.Emp;

public interface EmpDAO {

	public void insert(Emp emp);
	
	public List<Emp> getEmps();
	
	public Emp getEmpById(ObjectId objId);
	
	public void update(Emp emp);
	
	public void delete(ObjectId id);
}
