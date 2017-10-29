package com.avizva.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.ProjectDAO;
import com.avizva.model.Project;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDaoTest {

	@Autowired
	private ProjectDAO projectDAO;

	@Test
	public void addProjectTest() {
		Project project = new Project();
		project.setName("Test project");
		project = projectDAO.addProject(project);
		assertNotNull(project);
		assertNotNull(project.getId());
		assertNotNull(project.getProjectId());
	}

	@Test
	public void updateProject() {
		Project project = new Project();
		project.setName("Test project");
		project = projectDAO.addProject(project);
		assertNotNull(project);
		project.setName("Test 1");
		project = projectDAO.updateProject(project);
		assertNotNull(project);
		assertEquals("Test 1", project.getName());
	}

	@Test
	public void deleteProject() {
		Project project = new Project();
		project.setName("Test project");
		project = projectDAO.addProject(project);
		assertNotNull(project);
		project.setId(1);
		project = projectDAO.deleteProject(project);
		assertNotNull(project);
	}

}
