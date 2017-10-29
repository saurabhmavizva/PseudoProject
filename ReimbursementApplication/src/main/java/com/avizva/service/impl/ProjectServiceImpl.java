package com.avizva.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.ProjectDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Project;
import com.avizva.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	ProjectDAO projectDao;

	@Override
	public Project addProject(Project project, String createdBy) throws DaoException {
		project.setCreatedBy(createdBy);
		project.setModifiedBy(createdBy);
		Project proj = projectDao.addProject(project);
		return proj;
	}

	@Override
	public Project updateProject(Project project, String modifiedBy) throws DaoException {
		project.setModifiedBy(modifiedBy);
		Project proj = projectDao.updateProject(project);
		return proj;
	}

	@Override
	public Project deletePorject(Project project, String modifiedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProject() {

		try {
			return projectDao.getAllProject();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Project getProjectById(Integer id) {
		try {
			Project project = projectDao.getProjectById(id);
			return project;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Project> getActiveAndDeactiveProject() {
		try {
			return projectDao.getActiveAndDeactiveProject();
		} catch (Exception e) {
			return null;
		}
	}

}
