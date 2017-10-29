package com.avizva.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.ExchangeRatesDao;
import com.avizva.model.ExchangeRates;
import com.avizva.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	ExchangeRatesDao exchangeRatesDao;

	public List<ExchangeRates> addExchangeRatesService(List<ExchangeRates> rates) {

		List<ExchangeRates> addedExchangeRates = exchangeRatesDao.addExchangeRates(rates);
		return addedExchangeRates;

	}

	@Override
	public ExchangeRates getExchangeRatesService(String currency, Date billDate) {
		ExchangeRates currentExchangeRates = exchangeRatesDao.getExchangeRate(currency, billDate);
		return currentExchangeRates;
	}

	@Override
	public List<ExchangeRates> updateExchangeRatesService(List<ExchangeRates> rates) {
		// TODO Auto-generated method stub
		return null;
	}

}
