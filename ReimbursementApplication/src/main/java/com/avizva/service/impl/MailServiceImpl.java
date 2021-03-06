package com.avizva.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.MailFailureDao;
import com.avizva.model.MailFailure;
import com.avizva.service.MailService;
import com.avizva.utility.MailTemplate;

/****
 * 
 * @author Campus 2017
 *
 */
@Service
public class MailServiceImpl implements MailService {

	private static final Logger LOGGER = LogManager.getLogger();
	private Map<String, String> payload;

	private MailFailure mailFailure = new MailFailure();

	@Autowired
	private MailFailureDao mailFailureDao;

	@Autowired
	private Session session;

	@Async
	@Transactional
	public void sendRegistrationMail(String to, String employeeName, String password) {
		payload = new HashMap<String, String>();
		LOGGER.info("Storing employee name and password in payload");
		payload.put("<employee_Name>", employeeName);
		payload.put("<temporaryPassword>", password);
		String message = MailTemplate.REGISTRATION_MESSAGE;
		String subject = MailTemplate.REGISTRATION_SUBJECT;
		for (Map.Entry<String, String> entry : payload.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		String status = sendMail(to, message, subject);
		if (status.equals("failure")) {

			mailFailure.setMailTo(to);
			mailFailure.setMessage(message);
			mailFailure.setSubject(subject);
			mailFailureDao.addMailFailure(mailFailure);
		}
	}

	@Async
	@Transactional
	public void sendForgotPasswordMail(String to, String employeeName, String password) {
		payload = new HashMap<String, String>();
		LOGGER.info("Storing employee name and password in payload");
		payload.put("<employee_Name>", employeeName);
		payload.put("<password>", password);
		String message = MailTemplate.FORGOT_PASSWORD_MESSAGE;
		String subject = MailTemplate.FORGOT_PASSWORD_SUBJECT;
		for (Map.Entry<String, String> entry : payload.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		String status = sendMail(to, message, subject);
		if (status.equals("failure")) {

			mailFailure.setMailTo(to);
			mailFailure.setMessage(message);
			mailFailure.setSubject(subject);
			mailFailureDao.addMailFailure(mailFailure);
		}
	}

	@Async
	public void sendNewRequestSubmissionMail(String to, String employeeName, String requestId, String requestedAmount) {
		payload = new HashMap<String, String>();
		LOGGER.info("Storing employee name and password in payload");
		payload.put("<employee_Name>", employeeName);
		payload.put("<request_Id>", requestId);
		payload.put("<requested_Amount>", requestedAmount);
		String message = MailTemplate.NEW_REIMBURSEMENT_MESSAGE;
		String subject = MailTemplate.NEW_REIMBURSEMENT_SUBJECT;
		for (Map.Entry<String, String> entry : payload.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		sendMail(to, message, subject);

	}

	@Async
	public void sendPendingRequestMail(String to, String authorityName, String requestId, String requestedAmount) {
		payload = new HashMap<String, String>();
		LOGGER.info("Storing authority name and request id in payload");
		payload.put("<approving_Authority>", authorityName);
		payload.put("<request_Id>", requestId);
		payload.put("<requested_Amount>", requestedAmount);
		String message = MailTemplate.PENDING_REIMBURSEMENT_MESSAGE;
		String subject = MailTemplate.PENDING_REIMBURSEMENT_SUBJECT;
		for (Map.Entry<String, String> entry : payload.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		sendMail(to, message, subject);

	}

	@Async
	public void sendRequestStatusMail(String to, String employeeName, String requestId, String status, String authority,
			String requestedAmount, String approvedAmount) {
		payload = new HashMap<String, String>();
		LOGGER.info("Storing employee name and password in payload");
		payload.put("<employee_Name>", employeeName);
		payload.put("<request_Id>", requestId);
		payload.put("<status>", status);
		payload.put("<authority>", authority);
		payload.put("<requested_Amount>", requestedAmount);
		payload.put("<approved_Amount>", approvedAmount);
		String message = MailTemplate.ACTION_MESSAGE;
		String subject = MailTemplate.ACTION_SUBJECT;
		for (Map.Entry<String, String> entry : payload.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		sendMail(to, message, subject);
	}

	public String sendMail(String to, String message, String subject) {

		LOGGER.info("Creating a new e-mail message");
		Message msg = new MimeMessage(session);

		try {
			InternetAddress[] toAddresses = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(message, "text/html");
			LOGGER.info("Sending mail to " + to + " with subject " + subject);
			Transport.send(msg);
			LOGGER.info("Mail sent");
			return "success";
		} catch (MessagingException e) {
			LOGGER.error("Exception occured, mail not sent");
			return "failure";
		}
	}

}
