package com.avizva.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.AllowanceDAO;
import com.avizva.dao.DesignationDAO;
import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;
import com.avizva.model.Designation;
import com.avizva.service.AllowanceService;

@Service
public class AllowanceServiceImpl implements AllowanceService {

	@Autowired
	AllowanceDAO allowanceDao;

	@Autowired
	DesignationDAO designationDao;

	@Override
	public Allowance addAllowance(Allowance allowance, String createdBy) throws DaoException {
		allowance.setCreatedBy(createdBy);
		allowance.setModifiedBy(createdBy);
		return allowanceDao.addAllowance(allowance);
	}

	@Override
	public Allowance deleteAllowance(Allowance allowance, String modifiedBy) {
		allowance.setModifiedBy(modifiedBy);
		return allowanceDao.deleteAllowance(allowance);
	}

	@Override
	public Allowance updateAllowance(Allowance allowance, String modifiedBy) throws DaoException {
		allowance.setModifiedBy(modifiedBy);
		return allowanceDao.updateAllowance(allowance);
	}

	@Override
	public List<Allowance> viewAllowancesByDesignationId(Integer designationId) {

		return allowanceDao.viewAllowancesByDesignationId(designationId);
	}

	@Override
	public List<Allowance> viewAllAllowance() {

		return allowanceDao.viewAllAllowance();
	}

	@Override
	public List<Allowance> addNewCategoryToAllowance(Integer categoryId, String createdBy) throws DaoException {
		List<Allowance> newAllowances = new ArrayList<Allowance>();
		List<Designation> designationList = designationDao.viewActiveAndDeactiveDesignation();
		for (Designation d : designationList) {
			Allowance allowance = new Allowance();
			allowance.setAppliesToCategoryId(categoryId);
			allowance.setCreatedBy(createdBy);
			allowance.setModifiedBy(createdBy);
			allowance.setEnabled(true);
			allowance.setAppliesToDesignationId(d.getId());
			allowance.setAllowanceLimit(0f);
			allowanceDao.addAllowance(allowance);
			newAllowances.add(allowance);
		}
		return newAllowances;
	}

	@Override
	public Allowance viewAllowanceById(Integer id) {

		return allowanceDao.viewAllowanceById(id);
	}

}
