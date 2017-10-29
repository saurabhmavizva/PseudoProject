package com.avizva.dao;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;

/**
 * This DAO is used to CRUD operation for the Allowance Object in the Model
 * Class
 * 
 * @author Campus2017
 *
 */
public interface AllowanceDAO {
	/**
	 * This methods adds a new Allowance Limit for Category
	 * 
	 * @param allowance
	 * @return
	 * @throws DaoException
	 */
	public Allowance addAllowance(Allowance allowance) throws DaoException;

	/**
	 * This method removes the allowance from the Category
	 * <p>
	 * this method sets the enabled flag to false
	 * 
	 * @param allowance
	 * @return
	 */
	public Allowance deleteAllowance(Allowance allowance);

	/**
	 * This method updates the Allowance Object
	 * 
	 * @param allowance
	 * @return
	 * @throws DaoException
	 */
	public Allowance updateAllowance(Allowance allowance) throws DaoException;

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
	public List<Allowance> viewAllAllowance();

	public Allowance viewAllowanceById(Integer id);
}
