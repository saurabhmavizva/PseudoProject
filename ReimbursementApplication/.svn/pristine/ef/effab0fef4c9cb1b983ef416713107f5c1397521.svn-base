package com.avizva.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.ReimbursementItemDAO;
import com.avizva.model.ReimbursementItem;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReimbursementItemDaoTest {

	@Autowired
	private ReimbursementItemDAO reimbursementItemDAO;

	@Test
	public void addReimbursementItemTest() {
		ReimbursementItem reimbursementItem = new ReimbursementItem();
		reimbursementItem.setAmount(20000d);
		reimbursementItem.setBillNumber("234234");
		reimbursementItem.setBillDate(new Date());
		reimbursementItem = reimbursementItemDAO.addReimbursementItem(reimbursementItem);
		assertNotNull(reimbursementItem);
		assertNotNull(reimbursementItem.getId());
	}

	@Test
	public void updateReimbursementItem() {
		ReimbursementItem reimbursementItem = new ReimbursementItem();
		reimbursementItem.setAmount(20000d);
		reimbursementItem.setBillNumber("234234");
		reimbursementItem.setBillDate(new Date());
		reimbursementItem = reimbursementItemDAO.addReimbursementItem(reimbursementItem);
		reimbursementItem.setBillDate(new Date());
		reimbursementItem = reimbursementItemDAO.updateReimbursementItem(reimbursementItem);
		assertNotNull(reimbursementItem);
	}

	@Test
	public void deleteReimbursementItem() {
		ReimbursementItem reimbursementItem = new ReimbursementItem();
		reimbursementItem.setAmount(20000d);
		reimbursementItem.setBillNumber("234234");
		reimbursementItem.setBillDate(new Date());
		reimbursementItem = reimbursementItemDAO.addReimbursementItem(reimbursementItem);
		reimbursementItem.setId(1);
		reimbursementItem = reimbursementItemDAO.deleteReimbursementItem(reimbursementItem);
		assertNotNull(reimbursementItem);
	}

}
