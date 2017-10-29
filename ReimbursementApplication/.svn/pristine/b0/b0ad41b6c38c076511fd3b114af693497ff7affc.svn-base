package com.avizva.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	private String businessMessage;

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, String businessException) {
		super(message);
		this.businessMessage = businessException;
	}

	public String getBusinessMessage() {
		return businessMessage;
	}

	public void setBusinessMessage(String businessMessage) {
		this.businessMessage = businessMessage;
	}

}
