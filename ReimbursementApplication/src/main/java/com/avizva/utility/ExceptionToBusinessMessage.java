package com.avizva.utility;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ExceptionToBusinessMessage {
	public static String getBusinessMessageFromConstraintException(ConstraintViolationException exception) {
		String message = "";
		Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
		for (ConstraintViolation<?> violation : violations) {
			violation.getConstraintDescriptor();
			message += violation.getPropertyPath().toString() + " " + violation.getMessage();
			break;
		}
		return message;
	}
}
