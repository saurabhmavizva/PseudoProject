package com.avizva.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.avizva.dao.CategoryDAO;
import com.avizva.model.Category;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoTest {

	@Autowired
	private CategoryDAO categoryDAO;

	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setName("Telephone bill");
		category = categoryDAO.addCategory(category);
		assertNotNull(category);
		assertNotNull(category.getId());
		assertNotNull(category.getCategoryId());
		assertEquals("Telephone bill", category.getName());
	}

	@Test
	public void updateCategoeyTest() {
		Category category = new Category();
		category.setName("Telephone bill");
		category = categoryDAO.addCategory(category);
		category.setName("Bill");
		category = categoryDAO.updateCategory(category);
		assertNotNull(category);
		assertNotNull(category.getId());
		assertEquals("Name updated", "Bill", category.getName());
	}

	@Test
	public void deleteCategoryTest() {
		Category category = new Category();
		category.setName("Telephone bill");
		category = categoryDAO.addCategory(category);
		category.setId(1);
		Category deletedCategory = categoryDAO.deleteCategory(category);
		assertNotNull(deletedCategory);
	}

}
