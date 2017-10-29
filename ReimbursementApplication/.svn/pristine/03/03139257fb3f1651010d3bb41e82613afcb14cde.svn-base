package com.avizva.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avizva.model.ExchangeRates;
import com.avizva.pojo.CurrencyConversionResponse;
import com.avizva.service.ExchangeRateService;
import com.google.gson.Gson;

@Controller
public class AddHistoricalExchangeRates {

	@Autowired
	private ExchangeRateService exchangeRateService;

	private static final Logger LOGGER = LogManager.getLogger();

	@Value("${currencies.names}")
	private String currencies;

	@RequestMapping("/addExchangeRates")
	@ResponseBody
	public String addExchangeRates(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date to) throws IOException {
		Calendar start = Calendar.getInstance();
		start.setTime(from);
		Calendar end = Calendar.getInstance();
		end.setTime(to);
		List<String> currencyList = Arrays.asList(currencies.split(" "));
		List<ExchangeRates> exchangeRatesList;
		for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			ExchangeRates testExchangeRates = exchangeRateService.getExchangeRatesService("USD", date);
			if (testExchangeRates == null) {
				exchangeRatesList = new ArrayList<>();
				for (String currencyname : currencyList) {
					ExchangeRates exchangeRates = new ExchangeRates();

					double rate = getCurrencyRate(currencyname, date);
					exchangeRates.setCurrency(currencyname);
					exchangeRates.setRate(1 / rate);
					exchangeRates.setExchangeRateDate(date);
					exchangeRatesList.add(exchangeRates);
				}
				exchangeRateService.addExchangeRatesService(exchangeRatesList);
			}
		}
		return "success";
	}

	public static double getCurrencyRate(String currencyname, Date forDate) throws IOException {

		String api = "http://api.fixer.io/";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CurrencyConversionResponse response = getResponse(api + format.format(forDate) + "?base=INR");

		if (response != null) {

			String rate = response.getRates().get(currencyname);

			double conversionRate = Double.valueOf((rate != null) ? rate : "0.0");

			return conversionRate;

		}

		return 0.0;

	}

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
