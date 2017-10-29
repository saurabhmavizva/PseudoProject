package com.avizva.dao;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Category;

/**
 * This DAO manages the CRUD operations for the Cateogory Model
 * 
 * @author Shivam.Mehta
 *
 */
public interface CategoryDAO {

	public Category addCategory(Category category) throws DaoException;

	public Category deleteCategory(Category category);

	public Category updateCategory(Category category) throws DaoException;

	public Category viewCategoryById(Integer categoryId);

	public List<Category> viewAllCategory();

	public List<Category> viewActiveAndDeactiveCategory();

}
