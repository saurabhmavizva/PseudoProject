package com.avizva.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

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
public class ProjectServiceTest {

	@Autowired
	ProjectDAO projectDao;

	@Test
	public void addProjectTest() {
		Project project = new Project();
		project.setName("Campus 2017");
		project.setEnabled(true);
		project.setCreatedBy("Test");
		project.setModifiedBy("Test");
		project.setCreatedDate(new Date());
		project.setModifiedDate(new Date());
		project = projectDao.addProject(project);
		assertNotNull(project);

	}

	@Test
	public void updateProject() {
		Project project = new Project();
		project.setName("Gamazon");
		project.setEnabled(true);
		project = projectDao.addProject(project);
		assertNotNull(project);
		project.setName("Game");
		project = projectDao.updateProject(project);
	}

}
