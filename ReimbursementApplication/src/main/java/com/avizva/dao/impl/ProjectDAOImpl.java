package com.avizva.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.constants.ExceptionMessages;
import com.avizva.constants.IdConstants;
import com.avizva.dao.ProjectDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This method is used to add a new project into the database
	 * 
	 * @param project
	 * @throws DaoException
	 * 
	 */
	@Transactional
	public Project addProject(Project project) throws DaoException {
		if (null == project) {
			LOGGER.error("Unexpected parameter sent");
			throw new DaoException(ExceptionMessages.NULL_PARAMETER_PROVIDED);
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Saving project object");
		project.setCreatedDate(new Date());
		project.setModifiedDate(new Date());
		project.setEnabled(true);
		try {
			session.save(project);
			project.setProjectId(IdConstants.PROJECT_ID + String.format("%1$07d", project.getId()));
			session.flush();
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving project", e);
			throw new DaoException(e.getMessage());
		} finally {
			session.clear();
		}
		LOGGER.info("project object saved successfully");
		return project;
	}

	/**
	 * This method is used to delete the project
	 * 
	 * @param project
	 */
	@Transactional
	public Project deleteProject(Project project) {
		if (null == project || project.getId() == null) {
			LOGGER.error("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Deleting project object from db");
		project.setModifiedDate(new Date());
		session.delete(project);
		LOGGER.info("Project object deleted successfully");
		return project;
	}

	/**
	 * This method is used to update the project into the database
	 * 
	 * @param project
	 * @throws DaoException
	 */
	@Transactional
	public Project updateProject(Project project) throws DaoException {
		if (null == project || null == project.getId()) {
			LOGGER.error("Unexpected parameter sent");
			throw new DaoException(ExceptionMessages.NULL_PARAMETER_PROVIDED);
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Updating project object");
		project.setModifiedDate(new Date());
		try {
			session.update(project);
			LOGGER.info("Project object updated successfully");
			session.flush();
		} catch (Exception e) {
			LOGGER.error("Error occured while updating project", e);
			throw new DaoException(e.getMessage());
		} finally {
			session.clear();
		}
		return project;
	}

	/**
	 * This method is used to fetch the Project by its name
	 * 
	 * @param id
	 */
	@Transactional
	public Project getProjectById(Integer id) {
		if (id == null) {
			LOGGER.error("Null id send to fetch project");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Fetching project with id " + id);
		return session.get(Project.class, id);
	}

	/**
	 * This method is used to fetch all the projects present in the database
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Project> getAllProject() {
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("fetching all enabled projects");
		Query query = session.createQuery("from Project where enabled=true order by projectid asc");
		return query.list();
	}

	/**
	 * This method is used to fetch all the projects present in the database
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Project> getActiveAndDeactiveProject() {
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("fetching all enabled projects");
		Query query = session.createQuery("from Project order by projectid asc");
		return query.list();
	}

}
