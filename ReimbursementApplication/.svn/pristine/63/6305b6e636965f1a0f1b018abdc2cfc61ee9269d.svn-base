package com.avizva.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.enums.CategoryType;
import com.avizva.enums.Role;
import com.avizva.model.Allowance;
import com.avizva.model.Category;
import com.avizva.model.Designation;
import com.avizva.model.Employee;
import com.avizva.model.ReimbursementItem;
import com.avizva.model.ReimbursementRequest;
import com.avizva.service.CategoryService;
import com.avizva.service.EmployeeService;
import com.avizva.service.ProjectService;
import com.avizva.service.ReimbursementRequestService;
import com.avizva.service.ReimbursementService;
import com.avizva.utility.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This Controller will manage all the request mapping for Reimbursement
 * Requests
 * 
 * @author Campus2017
 *
 */

@Controller
public class ReimbursementController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	ReimbursementRequestService reimbursementRequestService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	private ReimbursementService reimbursementService;

	@Autowired
	private ProjectService projectService;

	@Value("${currencies.names}")
	private String currencies;

	@RequestMapping("/reimbursementhistory")
	public ModelAndView reimbursementHistoryPage(HttpSession session) {
		Employee employee = employeeService.getEmployeeById((Integer) session.getAttribute("id"));
		List<ReimbursementRequest> reimbursementList = reimbursementRequestService
				.viewReimbursementRequestByEmployee(employee);
		List<String> categoryName = reimbursementRequestService.viewAllCategoryNameByEmployee(employee);
		String projectName = employeeService.getEmployeeById((Integer) session.getAttribute("id"))
				.getAssignedToProject().getName();
		List<CategoryType> categoryType = new ArrayList<>();
		EnumSet.allOf(CategoryType.class).forEach((x) -> {
			categoryType.add(x);
		});

		List<Category> categories = categoryService.viewAllCategories();
		List<String> allCategories = new ArrayList<String>();
		categories.forEach(category -> {
			allCategories.add(category.getName());
		});

		return new ModelAndView("reimbursementhistory")
				.addObject("reimbursementRequests", JsonConverter.toJSON(reimbursementList))
				.addObject("categoryName", JsonConverter.toJSON(categoryName))
				.addObject("projectName", JsonConverter.toJSON(projectName))
				.addObject("categoryType", JsonConverter.toJSON(categoryType))
				.addObject("allCategories", JsonConverter.toJSON(allCategories));
	}

	@RequestMapping("/reimbursementqueue")
	public ModelAndView reimbursementQueuePage(HttpSession httpSession) {
		Role role = (Role) httpSession.getAttribute("role");
		if (role != null && (role == Role.Manager || role == Role.Finance)) {
			List<ReimbursementRequest> requests = new ArrayList<>();
			String userEmail = (String) httpSession.getAttribute("email");
			if (role == Role.Manager) {
				requests.addAll(
						reimbursementRequestService.getReimbursementRequestsForApprovalByManager(userEmail, true));
				requests.addAll(
						reimbursementRequestService.getReimbursementRequestsForApprovalByManager(userEmail, false));
			} else {
				requests.addAll(
						reimbursementRequestService.getReimbursementRequestsForApprovalByFinance(userEmail, true));
				requests.addAll(
						reimbursementRequestService.getReimbursementRequestsForApprovalByFinance(userEmail, false));
			}
			return new ModelAndView("reimbursementQueue").addObject("reimbursementRequests",
					JsonConverter.toJSON(requests));
		}
		return new ModelAndView("error");
	}

	@RequestMapping(name = "processRequest", method = RequestMethod.POST)
	public ModelAndView processRequest(HttpSession httpSession, @RequestParam String comment,
			@RequestParam Integer reimbursementId, @RequestParam String selectedItemsString,
			@RequestParam String action) {
		Role role = (Role) httpSession.getAttribute("role");
		if (role != null) {
			Employee employee = employeeService.getEmployeeById((Integer) httpSession.getAttribute("id"));
			boolean draft = false;
			if ("Save as Draft".equals(action))
				draft = true;
			reimbursementRequestService.processRequest(reimbursementId, comment, employee, draft, selectedItemsString);
			if (draft)
				return new ModelAndView("redirect:/reimbursementqueue").addObject("msg", "Draft saved");
			else
				return new ModelAndView("redirect:/reimbursementqueue");

		}
		return new ModelAndView("error");
	}

	@RequestMapping("/myactionqueue")
	public ModelAndView myActionQueue(HttpSession session) {

		List<ReimbursementRequest> listRequests = new ArrayList<ReimbursementRequest>();

		List<CategoryType> categoryType = new ArrayList<>();
		EnumSet.allOf(CategoryType.class).forEach((x) -> {
			categoryType.add(x);
		});
		List<Category> categories = categoryService.viewAllCategories();
		List<String> allCategories = new ArrayList<String>();
		categories.forEach(category -> {
			allCategories.add(category.getName());
		});

		List<Category> nonPayrollCategories = reimbursementService.getNonPayrollCategories();
		List<String> allNonPayrollCategories = new ArrayList<String>();
		nonPayrollCategories.forEach(category -> {
			allNonPayrollCategories.add(category.getName());
		});

		String categoryTypeJson = JsonConverter.toJSON(categoryType);
		String allCategoriesJson = JsonConverter.toJSON(allCategories);
		String allNonPayrollCategoriesJson = JsonConverter.toJSON(allNonPayrollCategories);

		Role role = (Role) session.getAttribute("role");
		if (role == Role.Employee || role == Role.ROLE_ADMIN) {
			return new ModelAndView("error").addObject("msg",
					"You must be logged in as Manager/Finance role to access this page");
		}
		if (role == Role.Manager) {
			listRequests = reimbursementRequestService
					.getRequestsByManagerEmail((String) session.getAttribute("email"));
			return new ModelAndView("historyactionqueue")
					.addObject("reimbursementRequests", JsonConverter.toJSON(listRequests))
					.addObject("categoryType", categoryTypeJson)
					.addObject("allCategories", allNonPayrollCategoriesJson);
		} else if (role == Role.Finance) {
			listRequests = reimbursementRequestService
					.getRequestsByFinanceEmail((String) session.getAttribute("email"));
			return new ModelAndView("historyactionqueue")
					.addObject("reimbursementRequests", JsonConverter.toJSON(listRequests))
					.addObject("categoryType", categoryTypeJson).addObject("allCategories", allCategoriesJson);

		}
		return new ModelAndView("error").addObject("msg", "Page not available for user's role");
	}

	@RequestMapping("/addreimbursement")
	public ModelAndView showAddRequestPage(HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");
		Employee employee = employeeService.getEmployeeById(id);
		String projectName = reimbursementService.getProjectNameByEmployee(employee);
		String managerName = reimbursementService.getManagerNameByEmployee(employee);

		List<Category> payrollCategories = reimbursementService.getPayrollCategories();
		List<Category> nonPayrollCategories = reimbursementService.getNonPayrollCategories();
		Designation designation = employee.getDesignation();
		List<Allowance> allowanceList = designation.getAllowances();
		Map<String, Float> allowanceMap = new HashMap<String, Float>();
		allowanceList.forEach(allowance -> {
			if (allowance.getAppliesToCategory().getType() == CategoryType.PAYROLL)
				allowanceMap.put(allowance.getAppliesToCategory().getName(), allowance.getAllowanceLimit());
		});

		List<String> currencyList = Arrays.asList(currencies.split(" "));
		ModelAndView model = new ModelAndView("addreimbursement");
		model.addObject("projectName", projectName).addObject("managerName", managerName)
				.addObject("payrollCategories", JsonConverter.toJSON(payrollCategories))
				.addObject("nonPayrollCategories", JsonConverter.toJSON(nonPayrollCategories))
				.addObject("Currencies", JsonConverter.toJSON(currencyList))
				.addObject("allowanceMap", JsonConverter.toJSON(allowanceMap));

		return model;
	}

	@RequestMapping("/editsaved")
	public ModelAndView editSavedReimbursement(HttpSession session, @RequestParam("requestId") Integer requestId) {
		Integer id = (Integer) session.getAttribute("id");
		Employee employee = employeeService.getEmployeeById(id);

		ReimbursementRequest request = reimbursementService.checkSaved(requestId, employee);
		String managerName = projectService.getProjectById(request.getEmployee().getAssignedToProjectId())
				.getHeadedByEmployee().getFirstName() + " "
				+ projectService.getProjectById(request.getEmployee().getAssignedToProjectId()).getHeadedByEmployee()
						.getFirstName();
		List<String> currencyList = Arrays.asList(currencies.split(" "));

		return new ModelAndView("editsaved").addObject("request", JsonConverter.toJSON(request))
				.addObject("managerName", JsonConverter.toJSON(managerName))
				.addObject("Currencies", JsonConverter.toJSON(currencyList));
	}

	@RequestMapping(value = "/saveRequest", method = RequestMethod.POST)
	public ModelAndView saveRequest(HttpSession session, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("itemsList") String itemsList,
			@RequestParam(value = "isEdit", required = false) Integer requestId) {

		LOGGER.debug(itemsList);

		Boolean inDraft = true;
		Integer employeeId = (Integer) session.getAttribute("id");
		LOGGER.debug(itemsList + " " + categoryId);
		Gson gson = new Gson();
		Type type = new TypeToken<List<ReimbursementItem>>() {
		}.getType();
		List<ReimbursementItem> allItems = gson.fromJson(itemsList, type);
		ReimbursementRequest savedRequest;
		if (requestId != null) {
			savedRequest = reimbursementService.updateRequest(inDraft, employeeId, categoryId, allItems, session,
					requestId);
		} else {
			savedRequest = reimbursementService.saveRequest(inDraft, employeeId, categoryId, allItems, session);
		}
		if (savedRequest == null) {
			return new ModelAndView("redirect:/dashboard").addObject("msg",
					"Request Could Not Be Saved Error While Processing");
		}

		return new ModelAndView("redirect:/dashboard").addObject("msg", "Reqeuest saved check your History");
	}

	@RequestMapping(value = "/submitRequest", method = RequestMethod.POST)
	public ModelAndView submitRequest(HttpSession session, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("itemsList") String itemsList,
			@RequestParam(value = "isEdit", required = false) Integer requestId) {
		Boolean inDraft = false;
		Integer employeeId = (Integer) session.getAttribute("id");

		Gson gson = new Gson();
		Type type = new TypeToken<List<ReimbursementItem>>() {
		}.getType();
		List<ReimbursementItem> allItems = gson.fromJson(itemsList, type);
		ReimbursementRequest savedRequest;
		if (requestId != null) {
			savedRequest = reimbursementService.updateRequest(false, employeeId, categoryId, allItems, session,
					requestId);
		} else {
			savedRequest = reimbursementService.submitRequest(employeeId, categoryId, allItems, session);
		}
		return new ModelAndView("redirect:/dashboard").addObject("msg", "Request Placed");
	}

	@RequestMapping("/deleterequest")
	public ModelAndView deleteRequest(HttpSession session, @RequestParam(value = "isEdit") Integer requestId) {
		if (requestId == null) {
			return new ModelAndView("redirect:/dashboard").addObject("msg", "Could Not Delete Request Some Error");
		} else {
			Integer employeeId = (Integer) session.getAttribute("id");
			List<ReimbursementRequest> reimbursementRequests = reimbursementRequestService
					.viewReimbursementRequestsByEmployeeId(employeeId);
			ReimbursementRequest newRequest = null;
			for (ReimbursementRequest r : reimbursementRequests) {
				if (r.getId() == requestId)
					newRequest = r;
			}
			if (newRequest == null) {
				return new ModelAndView("redirect:/dashboard").addObject("msg", "Could Not Delete Request Some Error");
			}
			ReimbursementRequest req = reimbursementRequestService.deleteReimbursementRequest(newRequest);
			if (req != null) {
				return new ModelAndView("redirect:/dashboard").addObject("msg", "Request Deleted Successfully");
			} else {
				return new ModelAndView("redirect:/dashboard").addObject("msg", "Could Not Delete Request Some Error");

			}
		}
	}

}
