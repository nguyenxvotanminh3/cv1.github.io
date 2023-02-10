package com.nguyenminh.cv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenminh.cv1.dao.DaoInterface;
import com.nguyenminh.cv1.dao.EmployeeDAOImplement;
import com.nguyenminh.cv1.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private DaoInterface daoInterface;
	
	
	@Autowired
	public EmployeeServiceImpl(DaoInterface theEmployeeDAOImplement) {
		daoInterface = theEmployeeDAOImplement;
	}
	
	@Override
	@Transactional
	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
		return daoInterface.findAll();
	}

	@Override
	@Transactional
	public EmployeeEntity findById(int theId) {
		
		return  daoInterface.findById(theId);
	}

	@Override
	@Transactional
	public void save(EmployeeEntity theEmployee) {
		daoInterface.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		daoInterface.deleteById(theId);

	}

}
