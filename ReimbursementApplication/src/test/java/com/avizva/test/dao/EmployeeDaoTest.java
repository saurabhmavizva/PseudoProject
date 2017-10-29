package com.avizva.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.EmployeeDAO;
import com.avizva.model.Employee;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	public void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setFirstName("Kumar");
		employee.setLastName("Pratyaksh");
		employee.setEmail("kp@avizva.com");
		Employee savedEmployee = employeeDAO.addEmployee(employee);
		assertNotNull(savedEmployee);
		assertNotNull(employee.getId());
		assertNotNull(employee.getEmployeeId());
	}

	@Test
	public void updateEmployeeTest() {
		Employee employee = new Employee();
		employee.setFirstName("Kumar");
		employee.setLastName("Pratyaksh");
		employee.setEmail("kp@avizva.com");
		Employee savedEmployee = employeeDAO.addEmployee(employee);
		savedEmployee.setEmail("kp");
		savedEmployee = employeeDAO.updateEmployee(savedEmployee);
		assertNotNull(savedEmployee);
		assertEquals("kp", savedEmployee.getEmail());
	}

	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee();
		employee.setFirstName("Kumar");
		employee.setLastName("Pratyaksh");
		employee.setEmail("kp@avizva.com");
		Employee savedEmployee = employeeDAO.addEmployee(employee);
		savedEmployee.setId(1);
		savedEmployee = employeeDAO.deleteEmployee(savedEmployee);
		assertNotNull(savedEmployee);
	}

}
