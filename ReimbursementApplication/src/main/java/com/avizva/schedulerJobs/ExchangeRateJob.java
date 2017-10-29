package com.avizva.schedulerJobs;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.avizva.model.ExchangeRates;
import com.avizva.pojo.CurrencyConversionResponse;
import com.avizva.service.ExchangeRateService;
import com.google.gson.Gson;

/**
 * 
 * ExchangeRateJob is a scheduled job which is used for saving the exchange
 * rates of currencies with respect to base INR everyday.
 * 
 * @author Priyanshi.Tiwari
 */
@Service
public class ExchangeRateJob {

	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	ExchangeRateService exchangeRatesService;

	@Value("${currencies.names}")
	private String currencies;

	/**
	 * This is a scheduled method which will run everyday at 12:00 am
	 * 
	 */
	@Scheduled(cron = "${crontab.for.exchange.rate.update}")
	public void ExecuteProcedure() throws IOException {

		LOGGER.info("inside scheduler method for exchangerate");

		List<ExchangeRates> exchangeRatesList = new ArrayList<ExchangeRates>();
		List<String> currencyList = Arrays.asList(currencies.split(" "));

		for (String currencyname : currencyList) {
			ExchangeRates exchangeRates = new ExchangeRates();

			double rate = getCurrencyRate(currencyname);
			exchangeRates.setCurrency(currencyname);
			exchangeRates.setRate(1 / rate);
			exchangeRates.setExchangeRateDate(new Date());
			exchangeRatesList.add(exchangeRates);
		}

		LOGGER.info("list of currencies:" + exchangeRatesList);
		ExchangeRates exchangeRatesTest = exchangeRatesService.getExchangeRatesService("USD", new Date());
		try {
			if (exchangeRatesTest == null) {
				LOGGER.info("saving currencies with exchange rates in db");
				exchangeRatesService.addExchangeRatesService(exchangeRatesList);
			}
		} catch (Exception e) {

			LOGGER.error("error occured while adding Exchange Rates" + e);
		}

	}

	// API Provider URL
	private static final String API_PROVDIER = "http://api.fixer.io/latest?base=INR";

	/**
	 * 
	 * This method is used for getting the currency exchange rate from external
	 * API fixer.io.
	 * 
	 * @param currencyname
	 *            (value of currency for which exchange rate is required).
	 * @return double (returns the exchange rate in double format).
	 */
	public static double getCurrencyRate(String currencyname) throws IOException {

		CurrencyConversionResponse response = getResponse(API_PROVDIER);

		if (response != null) {

			String rate = response.getRates().get(currencyname);

			double conversionRate = Double.valueOf((rate != null) ? rate : "0.0");

			return conversionRate;

		}

		return 0.0;

	}

	/**
	 * This method is used for getting response from external API.
	 * 
	 * @param strUrl
	 *            (request in URL format that will be sent to API).
	 * @return CurrenncyConversionResponse object (external API data in form of
	 *         CurrencyConversionResponse Object)
	 * 
	 */
	private static CurrencyConversionResponse getResponse(String strUrl) throws IOException {

		CurrencyConversionResponse response = null;

		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer();

		if (strUrl == null || strUrl.isEmpty()) {

			LOGGER.error("Application error");
			return null;
		}

		URL url;

		try {
			url = new URL(strUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			InputStream stream = connection.getInputStream();

			int data = stream.read();

			while (data != -1) {

				sb.append((char) data);

				data = stream.read();
			}

			stream.close();

			response = gson.fromJson(sb.toString(), CurrencyConversionResponse.class);

		} catch (MalformedURLException e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();

		}
		return response;
	}

}