package com.avizva.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.avizva.constants.DashboardConstants;
import com.avizva.dao.EmployeeDAO;
import com.avizva.dao.ReimbursementItemDAO;
import com.avizva.dao.ReimbursementRequestDAO;
import com.avizva.enums.RequestState;
import com.avizva.model.Allowance;
import com.avizva.model.Employee;
import com.avizva.model.ReimbursementItem;
import com.avizva.model.ReimbursementRequest;
import com.avizva.service.DashboardFilter;

/**
 * This class gets the filtered data that is used in dashboard
 * 
 * @author Parul.Sharma
 *
 */
@Service
public class DashboardFilterImpl implements DashboardFilter {

	private static final Logger LOGGER = LogManager.getLogger(DashboardFilterImpl.class);

	Calendar calendarDate;

	@Autowired
	ReimbursementRequestDAO reimbursementRequestDAO;

	@Autowired
	ReimbursementItemDAO reimbursementItemDAO;

	@Autowired
	EmployeeDAO employeeDAO;

	@Value("${dashboard.fiscalYearStart}")
	String fiscalYearStart;

	/**
	 * This method is for fetching all the completed request from the list of
	 * requests
	 * 
	 * @param list
	 * @return completedRequests
	 */
	private int completedRequestsFilter(List<ReimbursementRequest> list) {

		List<ReimbursementRequest> list2 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() == 6;
		}).collect(Collectors.toList());
		int completedRequests = list2.size();
		return completedRequests;
	}

	/**
	 * This method is for fetching the totalRequests of a particular employee
	 * 
	 * @param list
	 * @return size of total request in number
	 */

	private int totalRequestFilter(List<ReimbursementRequest> list) {

		List<ReimbursementRequest> list1 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() > 0
					&& ((ReimbursementRequest) request).getState().ordinal() < 7;

		}).collect(Collectors.toList());

		int totalRequest = list1.size();
		return totalRequest;
	}

	/**
	 * This method is for fetching the requests that are still in process this
	 * does not include saved/draft requests returns the number of request that
	 * are in process
	 * 
	 */
	private int inProcessRequestFilter(List<ReimbursementRequest> list) {

		List<ReimbursementRequest> list4 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() > 1
					&& ((ReimbursementRequest) request).getState().ordinal() < 6;
		}).collect(Collectors.toList());
		int inProcessRequest = list4.size();
		return inProcessRequest;
	}

	/**
	 * This method is for checking all the saved request that have not been
	 * submitted yet
	 * 
	 * @param list
	 * @return number of savedRequests
	 */
	private int savedRequestsFilter(List<ReimbursementRequest> list) {

		List<ReimbursementRequest> list3 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() == 1;
		}).collect(Collectors.toList());
		int savedRequests = list3.size();
		return savedRequests;
	}

	/**
	 * This method is for fetching list of all request that have not been
	 * completed yet this method includes the request that have not been
	 * submitted yet or saved requests return list of request
	 */

	public List<ReimbursementRequest> pendingRequestsFilter(List<ReimbursementRequest> list) {
		List<ReimbursementRequest> list1 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() > 0
					&& ((ReimbursementRequest) request).getState().ordinal() < 6;
		}).collect(Collectors.toList());

		list1.forEach(reimbursementRequest -> {
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
		return list1;
	}

	/**
	 * this method will compare the constants and calls the corresponding method
	 * to fetch the details returns integer value
	 */
	@Override
	public int allRequestsFilter(List<ReimbursementRequest> list, int requestType) {
		if (requestType == DashboardConstants.totalRequests) {
			int totalRequests = totalRequestFilter(list);
			return totalRequests;

		}

		else if (requestType == DashboardConstants.inProcessRequests) {
			int inProcessRequests = inProcessRequestFilter(list);
			return inProcessRequests;
		} else if (requestType == DashboardConstants.completedRequests) {
			int completedRequests = completedRequestsFilter(list);
			return completedRequests;
		} else if (requestType == DashboardConstants.savedRequests) {
			int savedRequestsRequests = savedRequestsFilter(list);
			return savedRequestsRequests;
		}

		return 0;
	}

	@Override
	public List<ReimbursementRequest> completedRequestFilter(List<ReimbursementRequest> list) {
		List<ReimbursementRequest> list1 = (List<ReimbursementRequest>) list.stream().filter((request) -> {
			return ((ReimbursementRequest) request).getState().ordinal() == 6;

		}).collect(Collectors.toList());
		return list1;
	}

	@Override
	public Map<Integer, Double> getAllowancesLimitsForCategories(Integer employeeId) {
		Employee employee = employeeDAO.viewById(employeeId);
		List<Allowance> allowances = employee.getDesignation().getAllowances();
		Map<Integer, Double> limitsMap = new HashMap<>();
		allowances.forEach(allowance -> {
			limitsMap.put(allowance.getAppliesToCategoryId(),
					(double) (allowance.getAllowanceLimit() * (Calendar.getInstance().get(Calendar.MONTH) + 1)));
		});
		return limitsMap;
	}

	@Override
	public Map<Integer, Double> getUsedLimitsForAllowance(Integer employeeId) {
		Map<Integer, Double> usedMap = new HashMap<>();
		Employee employee = employeeDAO.viewById(employeeId);
		List<Allowance> allowances = employee.getDesignation().getAllowances();
		String query = "select sum(r.amountApproved) from ReimbursementRequest r where r.employeeId=" + employeeId
				+ " AND r.state=" + RequestState.COMPLETED.ordinal() + " AND to_char(r.submissionDate,'DD/MM/YYYY') >='"
				+ fiscalYearStart + "/" + Calendar.getInstance().get(Calendar.YEAR)
				+ "' group by r.categoryId having r.categoryId=";
		allowances.forEach(allowance -> {
			Double usedLimit = (Double) reimbursementRequestDAO
					.executeQuery(query + allowance.getAppliesToCategoryId());
			if (usedLimit == null) {
				usedLimit = 0D;
			}
			usedMap.put(allowance.getAppliesToCategoryId(), usedLimit);
		});
		return usedMap;
	}

}
