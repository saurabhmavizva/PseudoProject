package com.avizva.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.MailFailureDao;
import com.avizva.model.MailFailure;

/**
 * This class provides methods for CRUD operations on MailFailure model
 * 
 * @author Campus2017
 *
 */
@Repository
public class MailFailureDaoImpl implements MailFailureDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LogManager.getLogger();

	@Value("${cron.retryCount}")
	private Integer retryCount;

	/**
	 * Adds new mailFailure object in db
	 * 
	 * @param MailFailure
	 *            object
	 * @return saved object
	 */
	@Override
	@Transactional
	public MailFailure addMailFailure(MailFailure mailFailure) {
		if (mailFailure == null) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Saving mail in db");
		session.save(mailFailure);
		LOGGER.info("Mail saved successfully");
		return mailFailure;
	}

	/**
	 * Function to update a mailfailure object
	 * 
	 * @param mailFailure
	 *            the object to be updated
	 * @return the updated mail failure object
	 */
	@Override
	@Transactional
	public MailFailure updateMailFailure(MailFailure mailFailure) {
		if (mailFailure == null || mailFailure.getId() == null) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Updating mailFailure object");
		session.update(mailFailure);
		LOGGER.info("Successfully updated mailFailure object");
		return mailFailure;
	}

	/**
	 * Function to delete the mailFailure object
	 * 
	 * @param mailFailure
	 *            the object to be deleted
	 * @return the deleted mailfailure object
	 */
	@Override
	@Transactional
	public MailFailure deleteMailFailure(MailFailure mailFailure) {
		if (mailFailure == null || mailFailure.getId() == null) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Deleting mailFailure object");
		try {
			session.save(mailFailure);
			LOGGER.info("Successfully deleted mailfailure object");
		} catch (Exception e) {
			LOGGER.error("Exception occured while deleting mailFailure", e);
			return null;
		}
		return mailFailure;
	}

	/**
	 * Function to get mailFailure objects where retry count < 5
	 * 
	 * @return list of mailSender objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<MailFailure> getFailedMails() {
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Fetching mail sender objects where retryCount<" + retryCount);
		Query query = session.createQuery("from MailFailure where retryCount<" + retryCount);
		return query.list();
	}

}
