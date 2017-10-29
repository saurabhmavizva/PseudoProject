package com.avizva.service;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;

public interface AllowanceService {
	/**
	 * This methods adds a new Allowance Limit for Category
	 * 
	 * @param allowance
	 * @return
	 */
	public Allowance addAllowance(Allowance allowance, String createdBy) throws DaoException;

	/**
	 * This method removes the allowance from the Category
	 * <p>
	 * this method sets the enabled flag to false
	 * 
	 * @param allowance
	 * @return
	 */
	public Allowance deleteAllowance(Allowance allowance, String modifiedBy);

	/**
	 * This method updates the Allowance Object
	 * 
	 * @param allowance
	 * @return
	 */
	public Allowance updateAllowance(Allowance allowance, String modifiedBy) throws DaoException;

	/**
	 * This method is used to fetch the allowance by name of that allowance
	 * 
	 * @param designationId
	 *            TODO
	 * @return
	 */
	public List<Allowance> viewAllowancesByDesignationId(Integer designationId);

	/**
	 * This method is used to return all the Allowance type defined
	 * 
	 * @return
	 */
	public Allowance viewAllowanceById(Integer id);

	public List<Allowance> viewAllAllowance();

	public List<Allowance> addNewCategoryToAllowance(Integer categoryId, String createdBy) throws DaoException;

}
