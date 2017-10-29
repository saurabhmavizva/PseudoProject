package com.avizva.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.DesignationDAO;
import com.avizva.model.Designation;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DesignationDaoTest {

	@Autowired
	private DesignationDAO designationDAO;

	@Test
	public void addDesignationTest() {
		Designation designation = new Designation();
		designation.setName("SDE1");
		designation.setEnabled(true);
		designation = designationDAO.addDesignation(designation);
		assertNotNull(designation);
		assertNotNull(designation.getId());
		assertNotNull(designation.getDesignationId());
	}

	@Test
	public void updateDesignationTest() {
		Designation designation = new Designation();
		designation.setName("SDE1");
		designation.setEnabled(true);
		designation = designationDAO.addDesignation(designation);
		assertNotNull(designation);
		designation.setName("SDE2");
		designation = designationDAO.updateDesignation(designation);
		assertNotNull(designation);
		assertEquals("Designation updated", "SDE2", designation.getName());
	}

	@Test
	public void deleteDesignationTest() {
		Designation designation = new Designation();
		designation.setName("SDE1");
		designation.setEnabled(true);
		designation = designationDAO.addDesignation(designation);
		designation.setId(1);
		designation = designationDAO.deleteDesignation(designation);
		assertNotNull(designation);
	}

}
