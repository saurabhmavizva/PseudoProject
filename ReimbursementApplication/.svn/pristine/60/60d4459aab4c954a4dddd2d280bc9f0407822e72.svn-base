package com.avizva.service;

import java.util.List;

import com.avizva.exception.DaoException;
import com.avizva.model.Designation;

/**
 * This Service calls the DesignationDAO and performs operation like adding a
 * Designation, deleting a Designation , updating Designation
 * <p>
 * Only Employee with admin role can have access to service of add, delete and
 * update
 * 
 * @author Campus2017
 *
 */
public interface DesignationService {

	public Designation addDesignation(Designation designation, String createdBy) throws DaoException;

	public Designation updateDesignation(Designation designation, String modifiedBy) throws DaoException;

	public Designation deleteDesignation(Designation designation, String modifiedBy);

	public List<Designation> getAllDisgination();

	public List<Designation> getActiveAndDeactiveDisgination();

	public Designation getDesignationById(Integer id);
}
