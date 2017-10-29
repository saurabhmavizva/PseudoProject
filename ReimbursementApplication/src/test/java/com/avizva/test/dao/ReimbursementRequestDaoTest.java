package com.avizva.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.ReimbursementRequestDAO;
import com.avizva.model.ReimbursementRequest;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReimbursementRequestDaoTest {

	@Autowired
	private ReimbursementRequestDAO reimbursementRequestDAO;

	@Test
	public void addReimbursementRequestTest() {
		ReimbursementRequest reimbursementRequest = new ReimbursementRequest();
		reimbursementRequest.setAmountRequested(2000d);
		reimbursementRequest.setAmountApproved(2000d);
		reimbursementRequest = reimbursementRequestDAO.addReimbursementRequest(reimbursementRequest);
		assertNotNull(reimbursementRequest);
		assertNotNull(reimbursementRequest.getId());
		assertNotNull(reimbursementRequest.getReimbursementId());
	}

	@Test
	public void updateReimbursementRequestTest() {
		ReimbursementRequest reimbursementRequest = new ReimbursementRequest();
		reimbursementRequest.setAmountRequested(2000d);
		reimbursementRequest.setAmountApproved(2000d);
		reimbursementRequest = reimbursementRequestDAO.addReimbursementRequest(reimbursementRequest);
		assertNotNull(reimbursementRequest);
		reimbursementRequest.setAmountApproved(1000d);
		reimbursementRequest = reimbursementRequestDAO.updateReimbursementRequest(reimbursementRequest);
		assertNotNull(reimbursementRequest);
	}

	@Test
	public void deleteReimbursmentRequestTest() {
		ReimbursementRequest reimbursementRequest = new ReimbursementRequest();
		reimbursementRequest.setAmountRequested(2000d);
		reimbursementRequest.setAmountApproved(2000d);
		reimbursementRequest = reimbursementRequestDAO.addReimbursementRequest(reimbursementRequest);
		assertNotNull(reimbursementRequest);
		reimbursementRequest.setId(1);
		reimbursementRequest = reimbursementRequestDAO.deleteReimbursementRequest(reimbursementRequest);
		assertNotNull(reimbursementRequest);
	}

}
