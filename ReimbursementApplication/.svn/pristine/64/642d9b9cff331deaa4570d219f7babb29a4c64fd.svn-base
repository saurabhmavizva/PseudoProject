package com.avizva.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.enums.Role;
import com.avizva.model.Employee;
import com.avizva.service.EmployeeService;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	private Object EmployeeController;

	// @Test()
	// public void addEmployeeService() {
	// Employee employee = new Employee();
	// employee.setFirstName("FirstName");
	// employee.setLastName("LastName");
	// employee.setEmail("firstname@gmail.com");
	// employee.setFirstLogIn(false);
	// employee.setRole(Role.Employee);
	// assertNotNull(employeeService.addEmployee(employee, "admin"));
	// }

	@Test()
	public void updateEmployeeService() {
		Employee employee = new Employee();
		employee.setFirstName("FirstName");
		employee.setLastName("LastName");
		employee.setEmail("firstname@gmail.com");
		employee.setRole(Role.Employee);
		assertNotNull(employeeService.addEmployee(employee, "admin"));
		employee.setFirstName("FirstsecondName");

		assertNotNull(employeeService.updateEmployee(employee, "admin"));
	}

	// @Test
	// public void forgotPasswordAction() {
	// Employee employee = new Employee();
	// employee.setFirstName("FirstName");
	// employee.setLastName("LastName");
	// employee.setEmail("firstname@gmail.com");
	// employee.setRole(Role.Employee);
	// employeeService.addEmployee(employee, "admin");
	// String email = "abhinandangupta39@gmail.com";
	// assertNotNull(employeeService.forgotPasswordAction(email));
	// }

	// commented codes are broken owner please fix it.

}
