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
import com.avizva.dao.AllowanceDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;

/**
 * This DAO is used to CRUD operation for the Allowance Object in the Model
 * Class
 * 
 * @author Campus2017
 */
@Repository
public class AllowanceDAOImpl implements AllowanceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This methods adds a new Allowance Limit for Category
	 * 
	 * @param allowance
	 * @return saved allowance object
	 * @throws DaoException
	 */
	@Transactional
	public Allowance addAllowance(Allowance allowance) throws DaoException {
		if (null == allowance) {
			LOGGER.error("Unexpected parameter sent");
			throw new DaoException(ExceptionMessages.NULL_PARAMETER_PROVIDED);
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Adding new allowance");
		allowance.setCreatedDate(new Date());
		allowance.setModifiedDate(new Date());
		allowance.setEnabled(true);
		try {
			session.save(allowance);
			allowance.setAllowanceId(IdConstants.ALOWWANCE_ID + String.format("%1$07d", allowance.getId()));
			session.flush();
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving allowance");
			throw new DaoException(e.getMessage());
		} finally {
			session.clear();
		}

		LOGGER.info("Allowance info saved successfully");
		return allowance;
	}

	/**
	 * This method removes the allowance from the Category
	 * 
	 * @param allowance
	 * @return deleted allowance object
	 */
	@Transactional
	public Allowance deleteAllowance(Allowance allowance) {
		if (null == allowance || null == allowance.getId()) {
			LOGGER.error("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Deleting allowance");
		allowance.setModifiedDate(new Date());
		session.delete(allowance);
		LOGGER.info("Successfully deleted allowance");
		return allowance;
	}

	/**
	 * This method updates the Allowance Object
	 * 
	 * @param allowance
	 * @return updated allowance object
	 * @throws DaoException
	 */
	@Transactional
	public Allowance updateAllowance(Allowance allowance) throws DaoException {
		if (null == allowance || null == allowance.getId()) {
			LOGGER.error("Unexpected parameter sent");
			throw new DaoException(ExceptionMessages.NULL_PARAMETER_PROVIDED);
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Updating allowance");
		allowance.setModifiedDate(new Date());
		try {
			session.update(allowance);
			session.flush();
		} catch (Exception e) {
			LOGGER.error("Exception occured while updating alllowance");
			throw new DaoException(e.getMessage());
		} finally {
			session.clear();
		}
		LOGGER.info("Allowance updated successfully");
		return allowance;
	}

	/**
	 * This method is used to fetch the allowance by name of that allowance
	 * 
	 * @return List of allowances belonging to particular designation
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Allowance> viewAllowancesByDesignationId(Integer designationId) {

		if (designationId == null)
			return null;
		System.out.println("bi");
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Fetching allances applicable to designation with id " + designationId);
		Query query = session.createQuery("from Allowance where appliesToDesignationId=:designationId");
		query.setParameter("designationId", designationId);
		return query.list();
	}

	/**
	 * This method is used to return all the Allowance type defined
	 * 
	 * @return List of all enabled allowances
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Allowance> viewAllAllowance() {
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("fetching all allowance objects");
		Query query = session.createQuery("from Allowance where enabled=true order by allowanceid asc");
		return query.list();
	}

	@Transactional
	public Allowance viewAllowanceById(Integer id) {
		if (id == null)
			return null;
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Fetching allowance object with id " + id);
		return session.get(Allowance.class, id);
	}

}
