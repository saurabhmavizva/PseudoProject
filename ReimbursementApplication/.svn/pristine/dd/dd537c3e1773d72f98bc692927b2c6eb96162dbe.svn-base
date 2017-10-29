package com.avizva.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.EmployeeDAO;
import com.avizva.dao.ReimbursementItemDAO;
import com.avizva.dao.ReimbursementRequestDAO;
import com.avizva.enums.RequestState;
import com.avizva.enums.Role;
import com.avizva.model.Category;
import com.avizva.model.Employee;
import com.avizva.model.Project;
import com.avizva.model.ReimbursementItem;
import com.avizva.model.ReimbursementRequest;
import com.avizva.service.MailService;
import com.avizva.service.ReimbursementRequestService;
import com.avizva.utility.JsonConverter;

@Service
public class ReimbursementRequestServiceImpl implements ReimbursementRequestService {

	@Autowired
	ReimbursementRequestDAO reimbursementRequestDAO;
	@Autowired
	ReimbursementItemDAO reimbursementItemDAO;
	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	private MailService mailService;

	/**
	 * This method of Service is used to file a new Reimbursement Request with
	 * an initial status the Employee can either save the reimbursement request
	 * or forward the reimbursement request to its approving authority depending
	 * upon the type and its project
	 */
	public ReimbursementRequest addReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		return null;
	}

	/**
	 * This method is used to delete the reimbursement request created by the
	 * user
	 */
	public ReimbursementRequest deleteReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		List<ReimbursementItem> rI = reimbursementItemDAO
				.viewReimbursementItemsForReimbursementRequest(reimbursementRequest.getId());
		rI.forEach(requestItem -> {
			reimbursementItemDAO.deleteReimbursementItem(requestItem);
		});
		reimbursementRequest.setEmployee(null);
		reimbursementRequest.setCategory(null);
		reimbursementRequest.setItems(null);
		ReimbursementRequest req = reimbursementRequestDAO.deleteReimbursementRequest(reimbursementRequest);
		return req;

	}

	/**
	 * This method is used to update the reimbursement request This is invoked
	 * everytime when a change in status or the reimbursement request happens or
	 * a new Reimbursement Item is added in the reimbursement request
	 */
	public ReimbursementRequest updateReimbursementRequest(ReimbursementRequest reimbursementRequest) {
		return null;
	}

	/**
	 * This method is used to fetch all the reimbursement request genereated by
	 * a specific employee
	 * 
	 */
	public List<ReimbursementRequest> viewReimbursementRequestByEmployee(Employee employee) {
		List<ReimbursementRequest> reimbursementRequestList = reimbursementRequestDAO
				.viewReimbursementRequestsByEmployeeId(employee.getId());
		reimbursementRequestList.forEach(reimbursementRequest -> {
			reimbursementRequest.setEmployee(null);
			// reimbursementRequest.setCategory(null);
			List<ReimbursementItem> reimbursementItemList = reimbursementItemDAO
					.viewReimbursementItemsForReimbursementRequest(reimbursementRequest.getId());

			reimbursementItemList.forEach(reimbursementItem -> {
				reimbursementItem.setRequest(null);
			});

			reimbursementRequest.setItems(reimbursementItemList);

		});

		return reimbursementRequestList;
	}

	public List<String> viewAllCategoryNameByEmployee(Employee employee) {
		List<ReimbursementRequest> reimbursementRequestList = reimbursementRequestDAO
				.viewReimbursementRequestsByEmployeeId(employee.getId());
		List<String> categoryName = new ArrayList<String>();
		reimbursementRequestList.forEach(reimbursementRequest -> {
			categoryName.add(reimbursementRequest.getCategory().getName());
		});
		return categoryName;

	}

	/**
	 * This method is used to fetch all the reimbursement requests
	 */
	public List<ReimbursementRequest> viewAllReimbursementRequest() {
		return null;
	}

	/**
	 * This method is invoked for reports where the requests have to be filtered
	 * by the Categories
	 */
	public List<ReimbursementRequest> viewAllReimbursementRequestbyCategory(Category category, Date StartDate,
			Date EndDate) {

		Integer id = category.getId();
		System.out.println(id);
		String hql = "from ReimbursementRequest where dateAdded BETWEEN '" + StartDate + "' AND '" + EndDate;

		List<ReimbursementRequest> reimbursementRequests = reimbursementRequestDAO.executeQueryWithFilter(hql);

		return reimbursementRequests;
	}

	/**
	 * This method is invoked for reports where the requests have to by filtered
	 * by Date on which they started and ended
	 */

	public List<ReimbursementRequest> viewAllReimbursementRequestByDate(Date startDate, Date endDate) {

		String hql = "from ReimbursementRequest where managerApprovalDate BETWEEN '" + startDate + "' AND '" + endDate
				+ "'";
		List<ReimbursementRequest> reimbursementRequests = reimbursementRequestDAO.executeQueryWithFilter(hql);

		return reimbursementRequests;
		// return null;
	}

	/**
	 * This method is invoked for reports where the requests have to be filtered
	 * by their status
	 * 
	 */
	public List<ReimbursementRequest> viewAllReimbursementRequestByStatus(ReimbursementRequest reimbursementRequest,
			Date startDate, Date endDate) {
		return null;
	}

	/**
	 * This method is invoked for reports where the requests have to be filtered
	 * by their projects
	 * 
	 */

	public List<ReimbursementRequest> viewAllReimbursementRequestByProject(Project project, Date startDate,
			Date endDate) {
		return null;
	}

	/**
	 * This method is invoked for reports where the requests have to be filtered
	 * by their type
	 */
	public List<ReimbursementRequest> viewAllReimbursementRequestByType(Category category, Date startDate,
			Date endDate) {
		return null;
	}

	@Override
	public List<ReimbursementRequest> getRequestsByManagerEmail(String managerEmail) {

		String query = "from ReimbursementRequest where manageremail='" + managerEmail + "' and state>3";

		List<ReimbursementRequest> reimbursementRequestList = reimbursementRequestDAO.executeQueryWithFilter(query);

		reimbursementRequestList.forEach(reimbursementRequest -> {
			reimbursementRequest.getEmployee().setRequests(null);
			reimbursementRequest.getEmployee().getAssignedToProject().setHeadedByEmployee(null);
			reimbursementRequest.getEmployee().setDesignation(null);
			List<ReimbursementItem> reimbursementItemList = reimbursementItemDAO
					.viewReimbursementItemsForReimbursementRequest(reimbursementRequest.getId());

			reimbursementItemList.forEach(reimbursementItem -> {
				reimbursementItem.setRequest(null);
			});

			reimbursementRequest.setItems(reimbursementItemList);

		});

		return reimbursementRequestList;
	}

	@Override
	public List<ReimbursementRequest> getRequestsByFinanceEmail(String financeEmail) {

		String query = "from ReimbursementRequest where financeemail='" + financeEmail + "' and state>5";

		List<ReimbursementRequest> reimbursementRequestList = reimbursementRequestDAO.executeQueryWithFilter(query);

		reimbursementRequestList.forEach(reimbursementRequest -> {
			reimbursementRequest.getEmployee().setRequests(null);
			reimbursementRequest.getEmployee().getAssignedToProject().setHeadedByEmployee(null);
			reimbursementRequest.getEmployee().setDesignation(null);
			List<ReimbursementItem> reimbursementItemList = reimbursementItemDAO
					.viewReimbursementItemsForReimbursementRequest(reimbursementRequest.getId());

			reimbursementItemList.forEach(reimbursementItem -> {
				reimbursementItem.setRequest(null);
			});

			reimbursementRequest.setItems(reimbursementItemList);

		});

		return reimbursementRequestList;
	}

	/**
	 * This method calls viewReimbursementRequestsByEmployeeId of
	 * reimbursementRequestDAO class return list
	 */
	public List<ReimbursementRequest> viewReimbursementRequestsByEmployeeId(Integer employeeId) {
		List<ReimbursementRequest> list = reimbursementRequestDAO.viewReimbursementRequestsByEmployeeId(employeeId);
		return list;
	}

	@Override
	public ReimbursementRequest saveAsDraft(ReimbursementRequest reimbursementRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementRequest> viewAllReimbursementRequestbyFiltersManager(Category category, Integer status,
			String managerEmail, Date startDate, Date endDate) {

		String query = "from ReimbursementRequest where manageremail='" + managerEmail + "' and state>3 ";
		if (null != category.getId() && category.getId() != -1) {
			query = query + " AND categoryId=" + category.getId();
		}
		if (null != status && status != -1) {
			if (status == 2)
				query = query + " AND amountApproved=0";
			else if (status == 1)
				query = query + " AND amountApproved = amountRequested";
			else if (status == 3)
				query = query + " AND amountApproved>0 AND amountApproved< amountRequested";

		}
		if (null != startDate && null != endDate) {
			query = query + " AND managerApprovalDate BETWEEN '" + startDate + "' AND '" + endDate + "'";
		}

		List<ReimbursementRequest> reimbursementRequests = reimbursementRequestDAO.executeQueryWithFilter(query);
		return reimbursementRequests;
	}

	@Override
	public List<ReimbursementRequest> viewAllReimbursementRequestbyFiltersFinance(Integer type, Category category,
			Project project, Integer status, Date startDate, Date endDate) {

		String query;

		query = "from ReimbursementRequest where state>5 ";

		if (category.getId() != null && category.getId() != -1) {
			query = query + " AND categoryId=" + category.getId();
		}

		if (null != status && status != -1) {
			if (status == 2)
				query = query + " AND amountApproved=0";
			else if (status == 1)
				query = query + " AND amountApproved = amountRequested";
			else if (status == 3)
				query = query + " AND amountApproved>0 AND amountApproved< amountRequested";

		}
		if (null != startDate && null != endDate) {
			query = query + " AND financeApprovalDate BETWEEN '" + startDate + "' AND '" + endDate + "'";
		}

		System.out.println("finance query" + query);
		List<ReimbursementRequest> reimbursementRequests = reimbursementRequestDAO.executeQueryWithFilter(query);
		List<ReimbursementRequest> finalReimbursementList = new ArrayList<ReimbursementRequest>();
		finalReimbursementList = reimbursementRequests.stream().filter(request -> {
			boolean flag = true;
			if (null != project.getId() && project.getId() != -1
					&& request.getEmployee().getAssignedToProjectId() != project.getId())
				flag = false;
			if (null != type && type != -1 && flag && request.getCategory().getType().ordinal() != type)
				flag = false;
			return flag;
		}).collect(Collectors.toList());

		return finalReimbursementList;
	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequestsForApprovalByManager(String managerEmail,
			boolean inDraft) {
		String query = "from ReimbursementRequest where manageremail='" + managerEmail + "'";
		if (inDraft) {
			query += " and state=" + RequestState.MANAGER_DRAFT.ordinal();
		} else {
			query += " and state=" + RequestState.WITH_MANAGER.ordinal();
		}
		query += " order by id";
		List<ReimbursementRequest> requests = reimbursementRequestDAO.executeQueryWithFilter(query);
		requests = getRequestsWithItemsPopulated(requests);
		return requests;
	}

	@Override
	public List<ReimbursementRequest> getReimbursementRequestsForApprovalByFinance(String financeEmail,
			boolean inDraft) {
		String query = "from ReimbursementRequest where state=";
		if (inDraft) {
			query += RequestState.FINANCE_DRAFT.ordinal() + " and financeemail='" + financeEmail + "'";
		} else {
			query += RequestState.WITH_FINANCE.ordinal();
		}
		query += " order by id";
		List<ReimbursementRequest> requests = reimbursementRequestDAO.executeQueryWithFilter(query);
		requests = getRequestsWithItemsPopulated(requests);
		return requests;
	}

	@Override
	public boolean processRequest(Integer requestId, String comment, Employee employee, boolean saveAsDraft,
			String selectedItemsString) {
		List<Integer> selectedItemsIds = JsonConverter.convertStringListToIntegerList(selectedItemsString);
		ReimbursementRequest reimbursementRequest = reimbursementRequestDAO.viewById(requestId);
		List<ReimbursementItem> items = reimbursementItemDAO.viewReimbursementItemsForReimbursementRequest(requestId);
		comment = comment.trim();
		reimbursementRequest.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
		if (comment.length() > 250)
			comment = comment.substring(0, 250);
		if (employee.getRole() == Role.Manager) {
			reimbursementRequest.setManagerComments(comment);
			reimbursementRequest.setManagerApprovalDate(new Date());

			if (selectedItemsIds.size() == 0 && !saveAsDraft) {
				reimbursementRequest.setState(RequestState.COMPLETED);
				items.forEach(item -> {
					item.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
					item.setManagerApproved(false);
					reimbursementItemDAO.updateReimbursementItem(item);
				});
			} else if (saveAsDraft) {
				reimbursementRequest.setState(RequestState.MANAGER_DRAFT);
				items.forEach(item -> {
					item.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
					if (selectedItemsIds.contains(item.getId())) {
						item.setManagerApproved(true);
					} else {
						item.setManagerApproved(false);
					}
					reimbursementItemDAO.updateReimbursementItem(item);
				});
			} else {
				reimbursementRequest.setState(RequestState.WITH_FINANCE);
				items.forEach(item -> {
					item.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
					if (selectedItemsIds.contains(item.getId())) {
						item.setManagerApproved(true);
					} else {
						item.setManagerApproved(false);
						item.setApproved(false);
					}
					reimbursementItemDAO.updateReimbursementItem(item);
				});
			}
			Double amountApproved = items.stream().filter(item -> {
				return item.getManagerApproved();
			}).mapToDouble(item -> item.getAmount()).sum();
			reimbursementRequest.setAmountApproved(amountApproved);
			reimbursementRequestDAO.updateReimbursementRequest(reimbursementRequest);
			return true;
		} else {
			reimbursementRequest.setFinanceApprovalDate(new Date());
			reimbursementRequest.setFinanceComments(comment);
			reimbursementRequest.setFinanceemail(employee.getEmail());
			if (saveAsDraft) {
				reimbursementRequest.setState(RequestState.FINANCE_DRAFT);
				items.forEach(item -> {
					item.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
					item.setFinanceApproved(selectedItemsIds.contains(item.getId()));
					reimbursementItemDAO.updateReimbursementItem(item);
				});
			} else {
				reimbursementRequest.setState(RequestState.COMPLETED);
				int count = 0;
				for (ReimbursementItem item : items) {
					item.setModifiedBy(employee.getEmail() + " " + employee.getEmployeeId());
					item.setFinanceApproved(selectedItemsIds.contains(item.getId()));
					item.setApproved(item.getFinanceApproved());
					reimbursementItemDAO.updateReimbursementItem(item);
					if (item.getFinanceApproved())
						count++;
				}
				reimbursementRequest.setApprovedItemsCount(count);
			}
			Double amountApproved = items.stream().filter(item -> {
				return item.getFinanceApproved();
			}).mapToDouble(item -> item.getAmount()).sum();
			reimbursementRequest.setAmountApproved(amountApproved);
			reimbursementRequestDAO.updateReimbursementRequest(reimbursementRequest);
			return true;
		}
	}

	private List<ReimbursementRequest> getRequestsWithItemsPopulated(List<ReimbursementRequest> requests) {
		requests.stream().forEach((request) -> {
			request.getEmployee().getAssignedToProject().setHeadedByEmployee(null);
			request.getEmployee().setDesignation(null);
			request.getEmployee().setRequests(null);
			List<ReimbursementItem> items = reimbursementItemDAO
					.viewReimbursementItemsForReimbursementRequest(request.getId());
			items.forEach(item -> item.setRequest(null));
			request.setItems(items);
		});
		return requests;
	}

	@Override
	public ReimbursementRequest viewRequestById(Integer requestId) {
		ReimbursementRequest request = reimbursementRequestDAO.viewById(requestId);
		return request;
	}

}
