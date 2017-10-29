package com.avizva.service;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Category;

public interface CategoryService {

	public Category addCategory(Category category, String createdBy) throws DaoException;

	public Category updateCategory(Category category, String modifiedBy) throws DaoException;

	public Category deleteCategory(Category category, String modifiedBy);

	public Category viewCategoryById(Integer id);

	public List<Category> viewAllCategories();

	public List<Category> viewActiveAndDeactiveCategories();

}
