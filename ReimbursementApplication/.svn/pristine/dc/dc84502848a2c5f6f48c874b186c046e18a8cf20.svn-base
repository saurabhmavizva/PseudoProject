package com.avizva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This is a model class for ExchangeRates. It contains exchangeRateDate,
 * currency and rate.
 * 
 * @author Priyanshi.Tiwari
 */

@Entity
public class ExchangeRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date exchangeRateDate;

	public Date getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	private String currency;

	private Double rate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ExchangeRates [id=" + id + ", currency=" + currency + ", rate=" + rate + "]";
	}

}
