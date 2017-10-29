package com.avizva.dao;

import java.util.Date;
import java.util.List;

import com.avizva.model.ExchangeRates;

public interface ExchangeRatesDao {

	public List<ExchangeRates> addExchangeRates(List<ExchangeRates> rates);

	public List<ExchangeRates> updateExchangeRates(List<ExchangeRates> rates);

	public ExchangeRates getExchangeRate(String currency, Date billDate);

}
