package com.avizva.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.CategoryDAO;
import com.avizva.enums.CategoryType;
import com.avizva.model.Category;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {

	@Autowired
	CategoryDAO categoryDao;

	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setName("Electricity Bill");
		category.setType(CategoryType.PAYROLL);
		category.setEnabled(true);
		category.setCreatedBy("Test");
		category.setModifiedBy("Test");
		category.setCreatedDate(new Date());
		category.setModifiedDate(new Date());
		category.setCategoryId("CAT0000002");
		category = categoryDao.addCategory(category);
		assertNotNull(category);
	}

	// @Test
	// public void updateCategoryTest() {
	// Category category = new Category();
	// category.setName("Travel Bill");
	// category.setType(CategoryType.PAYROLL);
	// category.setEnabled(true);
	// category = categoryDao.addCategory(category);
	// assertNotNull(category);
	// category.setName("Travel");
	// category.setEnabled(false);
	// category = categoryDao.updateCategory(category);
	// assertNotNull(category);
	//
	// }
}
