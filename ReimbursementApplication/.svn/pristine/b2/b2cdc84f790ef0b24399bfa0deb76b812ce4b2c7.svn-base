package com.avizva.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.dao.CategoryDAO;
import com.avizva.enums.CategoryType;
import com.avizva.enums.Role;
import com.avizva.exception.DaoException;
import com.avizva.model.Allowance;
import com.avizva.model.Category;
import com.avizva.model.Designation;
import com.avizva.model.Employee;
import com.avizva.model.Project;
import com.avizva.service.AllowanceService;
import com.avizva.service.CategoryService;
import com.avizva.service.DesignationService;
import com.avizva.service.EmployeeService;
import com.avizva.service.ProjectService;
import com.avizva.utility.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class AdminController {
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	DesignationService designationService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	AllowanceService allowanceService;

	@Autowired
	CategoryDAO categoryDao;

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@Value("${exception.custom.general.saveMessage}")
	private String generalSaveMessage;
	@Value("${exception.custom.general.updateMessage}")
	private String generalUpdateMessage;

	@RequestMapping("/manageDesignation")
	public ModelAndView manageDesignation(HttpSession session) {
		List<Designation> designationList = designationService.getActiveAndDeactiveDisgination();
		List<Category> categoryList = categoryDao.viewAllCategory().stream().filter((category) -> {
			return category.getType() == CategoryType.PAYROLL;
		}).collect(Collectors.toList());

		for (Designation d : designationList) {
			d.getAllowances().forEach(allowance -> allowance.setAppliesToDesignation(null));
		}
		String designations = JsonConverter.toJSON(designationList);
		String categories = JsonConverter.toJSON(categoryList);

		return new ModelAndView("manageDesignation").addObject("designations", designations).addObject("categories",
				categories);
	}

	@RequestMapping("/addDesignation")
	public ModelAndView addDesignation(@Valid @ModelAttribute("Designation") Designation designation,
			@RequestParam String allowanceList, HttpSession session) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Object>>() {
		}.getType();
		List<Object> list = gson.fromJson(allowanceList, type);
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		for (Object l : list) {
			String jList = gson.toJson(l);
			Type type1 = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> mapStr = gson.fromJson(jList, type1);
			mapList.add(mapStr);

		}

		designation.setAllowances(null);

		Designation addedDesignation = new Designation();
		try {
			addedDesignation = designationService.addDesignation(designation, session.getAttribute("name").toString());
		} catch (DaoException e) {

			return new ModelAndView("redirect:/manageDesignation?msg=" + generalSaveMessage);
		}

		for (Map<String, String> strList : mapList) {
			Allowance allowance = new Allowance();
			allowance.setAppliesToCategoryId(Integer.parseInt(
					strList.get("appliesToCategoryId").substring(0, strList.get("appliesToCategoryId").indexOf("."))));
			allowance.setAllowanceLimit(Float.parseFloat(strList.get("allowanceLimit")));
			allowance.setAppliesToDesignationId(addedDesignation.getId());
			allowance.setEnabled(true);
			allowance.setAppliesToCategory(null);
			allowance.setAppliesToDesignation(null);
			try {
				allowanceService.addAllowance(allowance, session.getAttribute("name").toString());
			} catch (DaoException e) {

				return new ModelAndView("redirect:/manageDesignation?msg=" + generalSaveMessage);
			}
		}

		// Category disabledCategories=categoryService.

		List<Category> disabledCategories = categoryService.viewActiveAndDeactiveCategories().stream()
				.filter((category) -> {
					return (category.getType() == CategoryType.PAYROLL && category.getEnabled() == null);
				}).collect(Collectors.toList());
		for (Category disCat : disabledCategories) {
			Allowance allowance = new Allowance();
			allowance.setAppliesToCategoryId(disCat.getId());
			allowance.setAllowanceLimit(0f);
			allowance.setAppliesToDesignationId(addedDesignation.getId());
			allowance.setEnabled(false);
			allowance.setAppliesToCategory(null);
			allowance.setAppliesToDesignation(null);
			try {
				allowanceService.addAllowance(allowance, session.getAttribute("name").toString());
			} catch (DaoException e) {
				return new ModelAndView("redirect:/manageDesignation?msg=" + generalSaveMessage);
			}
		}
		return new ModelAndView("redirect:/manageDesignation").addObject("msg", "New designation added");

	}

	@RequestMapping("/updateDesignation")
	public ModelAndView updateDesignation(@Valid @ModelAttribute("Designation") Designation designation,
			HttpSession session, @RequestParam String allowanceListEdited) {

		Gson gson = new Gson();
		Type type = new TypeToken<List<Object>>() {
		}.getType();
		List<Object> list = gson.fromJson(allowanceListEdited, type);
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		for (Object l : list) {
			String jList = gson.toJson(l);
			Type type1 = new TypeToken<Map<String, String>>() {
			}.getType();
			Map<String, String> mapStr = gson.fromJson(jList, type1);
			mapList.add(mapStr);

		}

		designation.setAllowances(null);
		try {
			Designation updatedDesignation = designationService.updateDesignation(designation,
					session.getAttribute("name").toString());
		} catch (DaoException e) {
			return new ModelAndView("redirect:/manageDesignation?msg=" + generalUpdateMessage);
		}

		LOGGER.debug("Designation's id: " + designation.getId());

		for (Map<String, String> strList : mapList) {
			Allowance allowance = allowanceService.viewAllowanceById(
					Integer.parseInt(strList.get("id").substring(0, strList.get("id").indexOf("."))));
			allowance.setAppliesToCategoryId(Integer.parseInt(
					strList.get("appliesToCategoryId").substring(0, strList.get("appliesToCategoryId").indexOf("."))));
			allowance.setAllowanceLimit(Float.parseFloat(strList.get("allowanceLimit")));
			try {
				allowanceService.updateAllowance(allowance, session.getAttribute("name").toString());
			} catch (DaoException e) {
				return new ModelAndView("redirect:/manageDesignation?msg=" + generalUpdateMessage);
			}
		}

		return new ModelAndView("redirect:/manageDesignation").addObject("msg", "Designation successfully updated");

	}

	@RequestMapping("/categorymanagement")
	public ModelAndView manageCategory() {
		List<Category> categoryList = categoryService.viewActiveAndDeactiveCategories();
		List<String> names = new ArrayList<>();
		if (categoryList.isEmpty()) {

		} else {

			for (Category c : categoryList) {
				names.add(c.getName());
			}
		}

		List<CategoryType> categoryType = new ArrayList<>();
		EnumSet.allOf(CategoryType.class).forEach((x) -> {
			categoryType.add(x);
		});

		String categories = JsonConverter.toJSON(categoryList);
		String categoryNames = JsonConverter.toJSON(names);
		return new ModelAndView("managecategory").addObject("categories", categories)
				.addObject("categoryNames", categoryNames)
				.addObject("categoryType", JsonConverter.toJSON(categoryType));

	}

	@RequestMapping("/registercategory")
	public ModelAndView registerCategory(@ModelAttribute("Category") Category category, HttpSession session) {

		String name = category.getName();
		List<Category> categories = categoryService.viewAllCategories();
		Boolean exist = false;
		for (Category c : categories) {
			if (name.equalsIgnoreCase(c.getName())) {
				exist = true;
				break;
			}
		}
		if (exist == true) {
			return new ModelAndView("redirect:/categorymanagement?msg=" + generalSaveMessage);
		}
		Category categoryAdded = new Category();
		try {
			categoryAdded = categoryService.addCategory(category,
					session.getAttribute("name") + " " + session.getAttribute("id"));

		} catch (DaoException e) {
			return new ModelAndView("redirect:/categorymanagement?msg=" + generalSaveMessage);
		}

		if (categoryAdded != null) {
			if (categoryAdded.getType().equals(CategoryType.PAYROLL)) {
				try {
					allowanceService.addNewCategoryToAllowance(categoryAdded.getId(),
							session.getAttribute("name").toString());
				} catch (DaoException e) {
					return new ModelAndView("redirect:/categorymanagement?msg=Error in setting allowance");
				}
			}
			return new ModelAndView("redirect:/categorymanagement?msg=Category Added Successfully");
		} else {
			return new ModelAndView("redirect:/categorymanagement?msg=Category Not Added");
		}

	}

	@RequestMapping("/updatecategory")
	public ModelAndView updateEmployee(@ModelAttribute("Category") Category category, HttpSession session) {

		try {
			Category categoryUpdated = categoryService.updateCategory(category,
					session.getAttribute("name") + " " + session.getAttribute("id"));
			return new ModelAndView("redirect:/categorymanagement?msg=Category Updated Successfully");
		} catch (DaoException e) {
			return new ModelAndView("redirect:/categorymanagement?msg=" + generalUpdateMessage);
		}

	}

	@RequestMapping("/projectmanagement")
	public ModelAndView manageProject() {
		List<Project> projectList = projectService.getActiveAndDeactiveProject();
		List<Employee> managerList = new ArrayList<>();
		if (projectList.isEmpty()) {

		} else {

			for (Project p : projectList) {
				managerList.add(employeeService.getEmployeeById(p.getHeadedByEmployeeId()));
				p.setHeadedByEmployee(null);

			}
			for (Employee e : managerList) {
				e.setAssignedToProject(null);
				e.setDesignation(null);
				e.setRequests(null);
				e.setRole(null);

			}
		}
		List<Employee> allEmployee = employeeService.getAllEmployee();
		List<Employee> newManagers = new ArrayList<>();
		if (allEmployee.isEmpty()) {

		} else {
			for (Employee e : allEmployee) {

				if ((designationService.getDesignationById(e.getDesignationId()).getHasApprovalAuthority() != null)
						&& (e.getRole() == Role.Manager)) {
					newManagers.add(e);
				}
			}
			if (newManagers.isEmpty()) {

			} else {

				for (Employee e : newManagers) {
					e.setAssignedToProject(null);
					e.setDesignation(null);
					e.setRequests(null);
					e.setRole(null);
				}
			}
		}

		return new ModelAndView("manageproject").addObject("projects", JsonConverter.toJSON(projectList))
				.addObject("managers", JsonConverter.toJSON(managerList))
				.addObject("newManagers", JsonConverter.toJSON(newManagers));
	}

	@RequestMapping("/registerproject")
	public ModelAndView registerProject(@ModelAttribute("Project") Project project, HttpSession session) {

		String name = project.getName();
		List<Project> projects = projectService.getActiveAndDeactiveProject();
		Boolean exist = false;
		for (Project p : projects) {
			if (name.equalsIgnoreCase(p.getName())) {
				exist = true;
				break;
			}
		}
		if (exist == true) {
			return new ModelAndView("redirect:/projectmanagement?msg=" + generalSaveMessage);
		}
		Project projectAdded = new Project();
		try {
			projectAdded = projectService.addProject(project,
					session.getAttribute("name") + " " + session.getAttribute("id"));
			if (projectAdded != null) {
				return new ModelAndView("redirect:/projectmanagement?msg=Project Added Successfully");
			} else {
				return new ModelAndView("redirect:/projectmanagement?msg=Project Not Added");
			}
		} catch (DaoException e) {
			return new ModelAndView("redirect:/projectmanagement?msg=" + generalSaveMessage);
		}

	}

	@RequestMapping("/updateproject")
	public ModelAndView updateProject(@ModelAttribute("Project") Project project, HttpSession session) {

		Project projectUpdated = new Project();
		try {
			projectUpdated = projectService.updateProject(project,
					session.getAttribute("name") + " " + session.getAttribute("id"));
			if (projectUpdated != null) {
				return new ModelAndView("redirect:/projectmanagement?msg=Project Updated Successfully");
			} else {
				return new ModelAndView("redirect:/projectmanagement?msg=Project Not Updated");
			}
		} catch (DaoException e) {
			return new ModelAndView("redirect:/projectmanagement?msg=" + generalUpdateMessage);
		}

	}

}
