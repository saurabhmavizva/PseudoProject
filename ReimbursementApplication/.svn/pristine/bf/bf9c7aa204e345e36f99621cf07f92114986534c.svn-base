package com.avizva.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.avizva.controller.EmployeeController;
import com.avizva.test.config.ApplicationContextConfigTest;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private EmployeeController employeeController;

	@Before
	public void setup() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(this.employeeController).setViewResolvers(viewResolver).build();

	}

	@Test
	public void testChangePasswordMapping() throws Exception {

		mockMvc.perform(get("/changepassword"))

				.andExpect(status().isOk())

				.andExpect(forwardedUrl("WEB-INF/views/changepassword.jsp"));

	}

	// @Test
	// public void testChangePasswordFormMapping() throws Exception {
	// MockHttpServletRequestBuilder request =
	// MockMvcRequestBuilders.post("/changepasswordform");
	//
	// ResultActions result = mockMvc.perform(request);
	//
	// result.andExpect(MockMvcResultMatchers.status().isOk());
	// result.andExpect(MockMvcResultMatchers.forwardedUrl("WEB-INF/views/dashboard.jsp"));
	//
	// //
	// .andExpect(status().isOk()).andExpect(forwardedUrl("WEB-INF/views/dashboard.jsp"));
	//
	// }

}
