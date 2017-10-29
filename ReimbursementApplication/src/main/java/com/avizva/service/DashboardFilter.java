package com.avizva.service;

import java.util.List;
import java.util.Map;

import com.avizva.model.ReimbursementRequest;

/**
 * This interface have two methods for getting pending requests other function
 * for applying filter and then fecthing details second method will fetch the
 * filter type and corresponding to that it fetches the details needed
 * 
 * @author Parul.Sharma
 *
 */
public interface DashboardFilter {

	public List<ReimbursementRequest> pendingRequestsFilter(List<ReimbursementRequest> list);

	public List<ReimbursementRequest> completedRequestFilter(List<ReimbursementRequest> list);

	public int allRequestsFilter(List<ReimbursementRequest> list, int filterType);

	public Map<Integer, Double> getAllowancesLimitsForCategories(Integer employeeId);

	public Map<Integer, Double> getUsedLimitsForAllowance(Integer employeeId);

}
