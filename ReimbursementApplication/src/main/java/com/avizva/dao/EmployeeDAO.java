package com.avizva.dao;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Employee;

/**
 * This method is used to do CRUD operations for the Employee Model
 * 
 * @author Campus2017
 *
 */
public interface EmployeeDAO {
	public Employee addEmployee(Employee employee) throws DaoException;

	public Employee deleteEmployee(Employee employee);

	public Employee updateEmployee(Employee employee) throws DaoException;

	public Employee viewById(Integer id);

	public Employee viewEmployeeByEmail(String email);

	public List<Employee> viewAllEmployee();

	public List<Employee> viewActiveAndDeactiveEmployee();

	public Employee validate(String email, String password);

}
