package com.nguyenminh.cv1.dao;

import java.util.List;

import com.nguyenminh.cv1.entity.EmployeeEntity;

public interface DaoInterface {
	public List<EmployeeEntity> findAll();
	
	public EmployeeEntity findById(int theId);
	
	public void save(EmployeeEntity theEmployee);
	
	public void deleteById(int theId);

}
