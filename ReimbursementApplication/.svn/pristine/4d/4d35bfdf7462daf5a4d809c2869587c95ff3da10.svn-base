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

import com.avizva.constants.IdConstants;
import com.avizva.dao.ReimbursementItemDAO;
import com.avizva.model.ReimbursementItem;

@Repository
public class ReimbursementItemDAOImpl implements ReimbursementItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This method is used to add a new Reimbursement Item into the database
	 * 
	 * @param reimbursementItem
	 */
	@Transactional
	public ReimbursementItem addReimbursementItem(ReimbursementItem reimbursementItem) {
		if (null == reimbursementItem) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Adding new reimbursement item");
		reimbursementItem.setCreatedDate(new Date());
		reimbursementItem.setModifiedDate(new Date());
		reimbursementItem.setEnabled(true);
		session.save(reimbursementItem);
		reimbursementItem.setItemId(IdConstants.ITEM_ID + String.format("%1$07d", reimbursementItem.getId()));
		LOGGER.info("Reimbursement item saved successfully");
		return reimbursementItem;
	}

	/**
	 * This method is used to delete a Reimbursement Item into the database
	 * 
	 * @param reimbursementItem
	 */
	@Transactional
	public ReimbursementItem deleteReimbursementItem(ReimbursementItem reimbursementItem) {
		if (null == reimbursementItem || null == reimbursementItem.getId()) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Deleting reimbursement item");
		reimbursementItem.setModifiedDate(new Date());
		session.delete(reimbursementItem);
		LOGGER.info("Reimbursement item deleted successfully");
		return reimbursementItem;
	}

	/**
	 * This method is used to update a Reimbursement Item
	 * 
	 * @param reimbursementItem
	 */
	@Transactional
	public ReimbursementItem updateReimbursementItem(ReimbursementItem reimbursementItem) {
		if (null == reimbursementItem || null == reimbursementItem.getId()) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Updating reimbursement item");
		reimbursementItem.setModifiedDate(new Date());
		session.update(reimbursementItem);
		LOGGER.info("Reimbursement item updated successfully");
		return reimbursementItem;
	}

	/**
	 * This method is used to fetch all the Reimbursement Items on the basis of
	 * requestId on which they are based
	 * 
	 * @param reimbursementRequestId
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReimbursementItem> viewReimbursementItemsForReimbursementRequest(Integer reimbursementRequestId) {
		if (reimbursementRequestId == null) {
			LOGGER.info("Null id send to fetch reimbursement items");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("fetching reimbursement items for request id " + reimbursementRequestId);
		Query query = session.createQuery("from ReimbursementItem where requestId=:requestId and enabled=true");
		query.setParameter("requestId", reimbursementRequestId);
		List<ReimbursementItem> returnList = query.list();
		return returnList;
	}

	@Override
	@Transactional
	public ReimbursementItem viewById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ReimbursementItem.class, id);
	}

}
