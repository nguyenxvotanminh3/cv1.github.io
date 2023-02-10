package com.nguyenminh.cv1.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenminh.cv1.dao.DaoInterface;
import com.nguyenminh.cv1.entity.EmployeeEntity;
import com.nguyenminh.cv1.service.EmployeeService;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	// expose "/employees" and return list of employees
	@GetMapping("/employee")
	public List<EmployeeEntity> findAll(){
	return employeeService.findAll()  ; } 
	
	
	// add mapping for Get /employee/employeeID
	
	@GetMapping("/employee/{employeeId}")
	public EmployeeEntity getEmployee(@PathVariable int employeeId) {
	
		EmployeeEntity theEmployeeEntity = employeeService.findById(employeeId);
		if (theEmployeeEntity == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return theEmployeeEntity;
		}
	
	// add mapping for Post/employees - add new employee
	@PostMapping("/employee")
	public EmployeeEntity addEmployeeEntity(@RequestBody EmployeeEntity theEmployeeEntity) {
		// just in case they pass an id in json set id to 0
		
		// this is to force a sae of new item instead of update
		
		theEmployeeEntity.setId(0);
		
		employeeService.save(theEmployeeEntity);
		
		return theEmployeeEntity;
	}
	// add mapping for PUT/employee - update exitsting employee
	
	@PutMapping("/employee")
	public EmployeeEntity upddateEmployeeEntity(@RequestBody EmployeeEntity theEmployeeEntity) {
		
		employeeService.save(theEmployeeEntity);
		
		return theEmployeeEntity;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		EmployeeEntity tempEmployeeEntity = employeeService.findById(employeeId);
		if (tempEmployeeEntity == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Delete" + employeeId ;
		}
	
	
}
