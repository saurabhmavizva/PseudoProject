package com.avizva.service;

import java.util.Date;
import java.util.List;

import com.avizva.model.ExchangeRates;

/***
 * This service calls ExchangeRateDAO and performs adding,updating and getting
 * exchangeRate operations.
 * 
 * @author Priyanshi.Tiwari
 */

public interface ExchangeRateService {

	public List<ExchangeRates> addExchangeRatesService(List<ExchangeRates> rates);

	public List<ExchangeRates> updateExchangeRatesService(List<ExchangeRates> rates);

	public ExchangeRates getExchangeRatesService(String currency, Date billDate);

}
