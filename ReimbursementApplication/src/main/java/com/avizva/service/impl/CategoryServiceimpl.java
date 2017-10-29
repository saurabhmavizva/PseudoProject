package com.avizva.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.CategoryDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Category;
import com.avizva.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	CategoryDAO categoryDao;

	@Override
	public Category addCategory(Category category, String createdBy) throws DaoException {
		category.setCreatedBy(createdBy);
		category.setModifiedBy(createdBy);

		Category cat = categoryDao.addCategory(category);
		return cat;

	}

	@Override
	public Category updateCategory(Category category, String modifiedBy) throws DaoException {
		category.setModifiedBy(modifiedBy);

		Category catUpdated = categoryDao.updateCategory(category);
		return catUpdated;

	}

	@Override
	public Category deleteCategory(Category category, String modifiedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category viewCategoryById(Integer id) {
		try {
			return categoryDao.viewCategoryById(id);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Category> viewAllCategories() {
		try {
			return categoryDao.viewAllCategory();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Category> viewActiveAndDeactiveCategories() {
		try {
			return categoryDao.viewActiveAndDeactiveCategory();
		} catch (Exception e) {
			return null;
		}

	}

}
