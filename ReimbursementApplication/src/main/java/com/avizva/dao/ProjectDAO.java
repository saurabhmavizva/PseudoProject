package com.avizva.dao;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Project;

/**
 * This DAO is used to perform CRUD Operations on the Project Model
 * 
 * @author Campus2017
 *
 */
public interface ProjectDAO {
	public Project addProject(Project project) throws DaoException;

	public Project deleteProject(Project project);

	public Project updateProject(Project project) throws DaoException;

	public Project getProjectById(Integer id);

	public List<Project> getAllProject();

	public List<Project> getActiveAndDeactiveProject();

}
