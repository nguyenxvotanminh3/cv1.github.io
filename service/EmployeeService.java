package com.nguyenminh.cv1.service;

import java.util.List;

import com.nguyenminh.cv1.entity.EmployeeEntity;


public interface EmployeeService {
	public List<EmployeeEntity> findAll();
	public EmployeeEntity findById(int theId);
	public void save(EmployeeEntity thEmployeeEntity );
	public String deleteById(int theId);
	
	
}
