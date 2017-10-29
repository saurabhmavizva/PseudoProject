package com.avizva.dao;

import java.util.List;

import com.avizva.model.MailFailure;

public interface MailFailureDao {

	public MailFailure addMailFailure(MailFailure mailFailure);

	public MailFailure updateMailFailure(MailFailure mailFailure);

	public MailFailure deleteMailFailure(MailFailure mailFailure);

	public List<MailFailure> getFailedMails();

}
