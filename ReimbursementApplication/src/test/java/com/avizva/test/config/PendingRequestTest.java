package com.avizva.test.config;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.ReimbursementRequestDAO;
import com.avizva.service.DashboardFilter;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PendingRequestTest {

	@Autowired
	private ReimbursementRequestDAO reimbursementRequestDAO;
	@Autowired
	private DashboardFilter dashboardFilter;

	@Test
	public void viewPendingRequestTest() {

		boolean result = (reimbursementRequestDAO.viewReimbursementRequestsByEmployeeId(1) != null);
		assertTrue(result);

	}

}
