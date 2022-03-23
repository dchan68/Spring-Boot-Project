package com.example.Springboot.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.Springboot.tutorial.entity.Department;
import com.example.Springboot.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class) //annotation needed bc controller methods occurs when endpoints are hit. Therefore this will mimick user hitting those api endpoints
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = new Department(1L, "IT", "Canada", "IT-02");
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = new Department("IT", "Canada", "IT-02");
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
		                "\t\"departmentName\":\"IT\",\n" +
		                "\t\"departmentAddress\":\"Canada\",\n" +
		                "\t\"departmentCode\":\"IT-02\"\n" +
		                "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void fetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department); 
		//get("/departments/1) bc that's what we had in @BeforeEach and want it back
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
		//$.departmentName is trying to match the json value with the department we are getting back in above line
		.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
	}
	

}
