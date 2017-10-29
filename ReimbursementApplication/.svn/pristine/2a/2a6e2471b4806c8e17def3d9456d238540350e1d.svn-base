package com.avizva.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.avizva.model.Allowance;
import com.avizva.model.ReimbursementRequest;
import com.avizva.service.ProgressBarFilterService;

@Service
public class ProgressBarFilterServiceImpl implements ProgressBarFilterService {

	@Override
	public List<Allowance> completedRequestFilter(List<Allowance> list) {
		List<Allowance> list1 = list.stream().filter((request) -> {
			return request.getAppliesToCategory().getType().ordinal() == 0;

		}).collect(Collectors.toList());
		return list1;
	}

	@Override
	public Map<Integer, Double> consumedLimit(List<Allowance> listAllowance,
			List<ReimbursementRequest> completedRequestsList) {
		Map<Integer, Double> amountMap = new HashMap<Integer, Double>();
		listAllowance.forEach((allownance) -> {
			Double totalAmountApproved = completedRequestsList.stream().filter((request) -> {
				return allownance.getAppliesToCategoryId() == request.getCategoryId();
			}).mapToDouble(request -> request.getAmountApproved()).sum();
			amountMap.put(allownance.getAppliesToCategoryId(), totalAmountApproved);
		});
		// TODO Auto-generated method stub
		return amountMap;
	}

}
