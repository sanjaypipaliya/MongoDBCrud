package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;



@Entity
public class Emp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="__id")
	private ObjectId empId;
	
	@Column(name="empname")
	private String empName;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	
	

	public ObjectId getEmpId() {
		return empId;
	}

	public void setEmpId(ObjectId empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
