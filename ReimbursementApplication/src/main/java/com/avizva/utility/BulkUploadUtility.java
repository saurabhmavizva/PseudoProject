package com.avizva.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avizva.enums.Role;
import com.avizva.exception.DaoException;
import com.avizva.model.Employee;
import com.avizva.service.EmployeeService;

@Service
public class BulkUploadUtility {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	public EmployeeService employeeService;

	@Value("${bulkUploadUtility.path}")
	String path;

	@Value("${bulkUploadUtility.fileName}")
	String fileName;

	@RequestMapping("/bulkUpload")
	public boolean uploadEmployeeRecords() {

		String record = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(path + fileName))) {
			while ((record = reader.readLine()) != null) {
				LOGGER.info("PROCCESSING RECORD");
				String[] fields = record.split(",");
				Employee employeeCheck = employeeService.getEmployeeByEmail(fields[4]);
				if (employeeCheck == null) {
					LOGGER.info("EMAIL NOT FOUND");

					Employee employee = new Employee();
					employee.setEmployeeId(fields[0]);
					employee.setFirstName(fields[1]);
					employee.setLastName(fields[2]);
					employee.setEmail(fields[3]);
					if (fields[4].equalsIgnoreCase("Active"))
						employee.setEnabled(true);
					else if (fields[4].equalsIgnoreCase("Disabled")) {
						employee.setEnabled(false);
					}
					employee.setRole(Role.Employee);
					try {
						employeeService.addEmployee(employee, "BulkUploadUtility");
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					LOGGER.info("FINISHED RECORD");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
