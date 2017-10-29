package com.avizva.service;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Project;

public interface ProjectService {

	public Project addProject(Project project, String createdBy) throws DaoException;

	public Project updateProject(Project project, String modifiedBy) throws DaoException;

	public Project deletePorject(Project project, String modifiedBy);

	public List<Project> getAllProject();

	public List<Project> getActiveAndDeactiveProject();

	public Project getProjectById(Integer id);

}
