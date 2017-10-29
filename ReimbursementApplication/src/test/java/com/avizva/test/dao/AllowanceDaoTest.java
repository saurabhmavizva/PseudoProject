package com.avizva.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.AllowanceDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AllowanceDaoTest {

	@Autowired
	private AllowanceDAO allowanceDAO;

	@Test
	public void addAllowanceTest() {
		Allowance allowance = new Allowance();
		allowance.setAllowanceLimit(100000000f);
		try {
			allowance = allowanceDAO.addAllowance(allowance);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(allowance);
		assertNotNull(allowance.getAllowanceId());
		assertNotNull(allowance.getId());
		assertEquals(100000000f, allowance.getAllowanceLimit(), 1.0f);
	}

	@Test
	public void addAllowanceNullTest() {
		Allowance allowance = null;
		try {
			allowance = allowanceDAO.addAllowance(null);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(allowance);
	}

	@Test
	public void updateAllowanceTest() {
		Allowance allowance = new Allowance();
		allowance.setAllowanceLimit(1000f);
		try {
			allowance = allowanceDAO.addAllowance(allowance);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allowance.setAllowanceLimit(12000f);
		allowanceDAO.updateAllowance(allowance);
		assertEquals(12000f, allowance.getAllowanceLimit(), 1.0f);
	}

	@Test
	public void updateAllowanceNullTest() {
		Allowance allowance = new Allowance();
		assertNull(allowanceDAO.updateAllowance(null));
		assertNull(allowanceDAO.updateAllowance(allowance));
	}

	@Test
	public void deleteAllowanceNullTest() {
		Allowance allowance = new Allowance();
		assertNull(allowanceDAO.deleteAllowance(null));
		assertNull(allowanceDAO.deleteAllowance(allowance));
	}

	@Test
	public void deleteAllowanceTest() {
		Allowance allowance = new Allowance();
		allowance.setAllowanceLimit(1000f);
		try {
			allowance = allowanceDAO.addAllowance(allowance);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allowance = allowanceDAO.deleteAllowance(allowance);
		assertNotNull(allowance);
	}

}
