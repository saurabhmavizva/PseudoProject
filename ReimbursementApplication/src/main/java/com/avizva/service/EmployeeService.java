package com.avizva.service;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Employee;

/**
 * This Service calls the EmployeeDAO and performs operation like adding an
 * Employee deleting an Employee updating Employee
 * <p>
 * Only Employee with admin access has roles can have access to service of add
 * delete and update
 * 
 * @author Campus2017
 *
 */
public interface EmployeeService {
	public Employee addEmployee(Employee employee, String createdBy) throws DaoException;

	public Employee deleteEmployee(Employee employee);

	public Employee updateEmployee(Employee employee, String modifiedBy) throws DaoException;

	public Employee getEmployeeById(Integer id);

	public Employee getEmployeeByEmail(String email);

	public List<Employee> getAllEmployee();

	public List<Employee> getActiveAndDeactiveEmployee();

	public Employee validate(String email, String password);

	public Employee forgotPasswordAction(String email) throws DaoException;

	public Employee changePassword(String email, String oldPassword, String newPassword);

}
