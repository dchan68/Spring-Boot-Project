package com.example.Springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Springboot.tutorial.entity.Department;
import com.example.Springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean //Mocking using mockito. This test class is just testing our service layer. Don't care how DepartmentRepository is working. Therefore need mock
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = new Department(1L, "Biology", "Canada", "Bio-01");
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Biology")).thenReturn(department);
	}
	
	@Test
	@DisplayName("Get data based on valid department name")
	//@Disabled //If this annotation is active, when this test class is being ran, then this test case will be skipped
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "Biology";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName()); //getDepartmentName is from DepartmentRepository file. Therefore need mock
	}

}
