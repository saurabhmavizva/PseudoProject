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

import com.avizva.dao.ExchangeRatesDao;
import com.avizva.model.ExchangeRates;

/**
 * Class for crud operations for exchange rate model
 * 
 * @author Campus2017
 *
 */
@Repository
public class ExchangeRatesDaoImpl implements ExchangeRatesDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Method to add exchange rates in db. This method needs to be called one
	 * time only when the application runs for the first time after that all
	 * opearations need to be done through update operation
	 * 
	 * @param List<ExchangeRates>
	 *            list of exchange rate objects
	 * 
	 * @return List of saved exchange rates
	 */
	@Override
	@Transactional
	public List<ExchangeRates> addExchangeRates(List<ExchangeRates> exchangeRates) {
		if (exchangeRates == null || exchangeRates.size() == 0) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Adding new exchange rate");
		exchangeRates.forEach((rate) -> {
			session.save(rate);
		});
		LOGGER.info("Successfully saved exchange rate");
		return exchangeRates;
	}

	/**
	 * Method to update exchange rates. This method will update the existing
	 * exchange rates in the db
	 * 
	 * @param List<ExchangeRates>
	 *            list of exchange rate objects
	 * @return list of updated exchange rates
	 */
	@Override
	@Transactional
	public List<ExchangeRates> updateExchangeRates(List<ExchangeRates> exchangeRates) {
		if (exchangeRates == null) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Updating exchange rate ");
		exchangeRates.forEach(rate -> {
			session.update(rate);
		});
		LOGGER.info("Successfully updated exchange rates");
		return exchangeRates;
	}

	/**
	 * Method to fetch exchange rates from db
	 * 
	 * @return List of exchange rates
	 */
	@Override
	@Transactional
	public ExchangeRates getExchangeRate(String currency, Date billDate) {
		if (null == currency || null == billDate) {
			LOGGER.info("Unexpected parameter sent");
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
		LOGGER.info("Fetching exchange rates");
		Query query = session.createQuery("from ExchangeRates where currency=:currency and exchangeRateDate=:billDate");
		query.setParameter("currency", currency);
		query.setDate("billDate", billDate);
		return (ExchangeRates) query.uniqueResult();
	}

}
