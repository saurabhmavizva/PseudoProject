package com.avizva.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.DesignationDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Designation;
import com.avizva.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	DesignationDAO designationDao;

	@Override
	public Designation addDesignation(Designation designation, String createdBy) throws DaoException {

		designation.setCreatedBy(createdBy);
		designation.setModifiedBy(createdBy);
		Designation designation1 = designationDao.addDesignation(designation);
		LOGGER.debug("Inside Designation add Service ");
		return designation1;
	}

	@Override
	public Designation updateDesignation(Designation designation, String modifiedBy) throws DaoException {

		designation.setModifiedBy(modifiedBy);
		Designation designation1 = designationDao.updateDesignation(designation);
		LOGGER.debug("Inside Designation update Service ");
		return designation1;
	}

	@Override
	public Designation deleteDesignation(Designation designation, String modifiedBy) {

		designation.setModifiedBy(modifiedBy);
		Designation designation1 = designationDao.deleteDesignation(designation);
		LOGGER.debug("Inside Designation delete Service ");
		return designation1;
	}

	@Override
	public List<Designation> getAllDisgination() {

		return designationDao.viewAllDesignation();
	}

	@Override
	public Designation getDesignationById(Integer id) {

		return designationDao.viewDesignationById(id);
	}

	@Override
	public List<Designation> getActiveAndDeactiveDisgination() {
		return designationDao.viewActiveAndDeactiveDesignation();
	}

}
