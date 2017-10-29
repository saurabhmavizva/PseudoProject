package com.avizva.schedulerJobs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.avizva.dao.MailFailureDao;
import com.avizva.model.MailFailure;
import com.avizva.service.MailService;

@Service
public class MailFailureJob {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	MailFailureDao mailFailureDao;

	@Autowired
	MailService mailService;

	@Scheduled(cron = "${crontab.retryInterval}")
	public void processFailedMails() {
		List<MailFailure> listMailFailure = mailFailureDao.getFailedMails();

		listMailFailure.forEach((mailFailure) -> {
			String result = mailService.sendMail(mailFailure.getMailTo(), mailFailure.getMessage(),
					mailFailure.getSubject());

			if (result.equals("failure")) {
				mailFailure.setRetryCount(mailFailure.getRetryCount() + 1);
				mailFailureDao.updateMailFailure(mailFailure);
			} else {
				mailFailureDao.deleteMailFailure(mailFailure);
			}
		});
	}
}
