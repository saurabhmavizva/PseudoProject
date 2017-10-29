package com.avizva.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.avizva.model.Category;
import com.avizva.model.Employee;
import com.avizva.model.ReimbursementItem;
import com.avizva.model.ReimbursementRequest;

public interface ReimbursementService {

	public List<Category> getPayrollCategories();

	public List<Category> getNonPayrollCategories();

	public String getProjectNameByEmployee(Employee employee);

	public String getManagerNameByEmployee(Employee employee);

	public String getManagerEmailByEmployee(Employee employee);

	public ReimbursementRequest saveRequest(Boolean inDraft, Integer employeeId, Integer categoryId,
			List<ReimbursementItem> allItems, HttpSession session);

	public ReimbursementRequest updateRequest(Boolean inDraft, Integer employeeId, Integer categoryId,
			List<ReimbursementItem> allItems, HttpSession session, Integer requestId);

	public ReimbursementRequest submitRequest(Integer employeeId, Integer categoryId, List<ReimbursementItem> allItems,
			HttpSession session);

	public ReimbursementRequest checkSaved(Integer requestId, Employee employee);
}
