package com.avizva.service;

/**
 * service to send email
 * 
 * @author Campus 2017
 *
 */

public interface MailService {

	/**
	 * Method to send mail for registration and one time password for first
	 * login
	 * 
	 * @param to
	 *            Email address of the user to whom the email is to be sent
	 * @param employeeName
	 *            Name of the employee
	 * @param password
	 *            the one time password that is valid for first login
	 */
	public void sendRegistrationMail(String to, String employeeName, String password);

	/**
	 * Method to send mail for setting password for forgot password
	 * 
	 * @param to
	 *            Email address of the user to whom the email is to be sent
	 * @param employeeName
	 *            Name of the employee
	 * @param password
	 *            the new password for login
	 */
	public void sendForgotPasswordMail(String to, String employeeName, String password);

	/**
	 * Method to send mail for submission of new reimbursement request
	 * 
	 * @param to
	 *            Email address of the authority to whom the email is to be sent
	 * @param authorityName
	 *            Name of the authority who will approve the request
	 * @param requestId
	 *            Request id of the current request which has been submitted
	 */
	public void sendPendingRequestMail(String to, String authorityName, String requestId, String requestedAmount);

	/**
	 * Method to send mail for submission of new reimbursement request
	 * 
	 * @param to
	 *            Email address of the user to whom the email is to be sent
	 * @param employeeName
	 *            Name of the employee
	 * @param requestId
	 *            Request id of the current request which has been submitted
	 */
	public void sendNewRequestSubmissionMail(String to, String employeeName, String requestId, String requestedAmount);

	/**
	 * Method to send mail for status of the reimbursement request
	 * 
	 * @param to
	 *            Email address of the user to whom the email is to be sent
	 * @param employeeName
	 *            Name of the employee
	 * @param requestId
	 *            Request id of the current request which has been submitted
	 * @param status
	 *            status of the request i.e. Approved or Rejected
	 * @param authority
	 *            authority is the action taker i.e. the approval or rejection
	 * 
	 */
	public void sendRequestStatusMail(String to, String employeeName, String requestId, String status,
			String authority, String requestedAmount, String approvedAmount);

	/**
	 * Method to send mail for rejected reimbursement request
	 * 
	 * @param to
	 *            Email address of the user to whom the email is to be sent
	 * @param payload
	 *            payload stores the details that are to be populated on mail
	 * @param message
	 *            Message body that is to be sent
	 * @param subject
	 *            subject for the mail
	 */
	public String sendMail(String to, String message, String subject);

}