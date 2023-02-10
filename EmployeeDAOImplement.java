package com.nguyenminh.cv1.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.nguyenminh.cv1.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImplement implements DaoInterface {
	
	// define field for entitymanager
	
		private EntityManager entityManager;
	
	// setup constructor injection
		
		@Autowired
		public EmployeeDAOImplement (EntityManager theEntityManager) {
			entityManager = theEntityManager;
			}
		@Override
		public List<EmployeeEntity> findAll() {
			// get the current hibernate session 
			Session currentSession = entityManager.unwrap(Session.class);
			// create a query
			Query<EmployeeEntity> theQuery = 
					currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class);
			
			// execute query and get result list
			List<EmployeeEntity> employees = theQuery.getResultList();
			// return the result
			
			return employees;
			
		}
		@Override
		public EmployeeEntity findById(int theId) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			// get the employee
			EmployeeEntity theEmployeeEntity = 
						currentSession.get(EmployeeEntity.class, theId);
			// retrn the employee
			return theEmployeeEntity;
		}
		
		@Override
		public void save(EmployeeEntity theEmployee) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			//save the employee
			currentSession.saveOrUpdate(theEmployee);
		}
		
		@Override
		public void deleteById(int theId) {
			Session currentSession = entityManager.unwrap(Session.class);
			
			@SuppressWarnings("deprecation")
			Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
			theQuery.setParameter("employeeId", theId);
			
			theQuery.executeUpdate();
			
					
		}
	
}
