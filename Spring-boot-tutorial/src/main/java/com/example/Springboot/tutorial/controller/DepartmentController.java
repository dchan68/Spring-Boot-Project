package com.example.Springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot.tutorial.entity.Department;
import com.example.Springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	//@Valid is part of hibernate validation. Is needed when RequestBody we're receiving contains a validation, in this case @NotBlank in Department class for departmentName
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {//will be passing request body since post is creating data. Will convert json data into our entity, which is Department, for our request
		//DepartmentService service = new DepartmentServiceImpl(); Spring boot already knows we have these class/ interface already created & knows these particular class are in our container. Spring can automatically
		//provide them. Therefore user doesn't have to create them on their own, hence they're commented out. Can implement by using @Autowired
		LOGGER.info("Inside saveDeartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id")Long departmentId) { //Mapping id to department id
		LOGGER.info("Inside fetchDepartmentById of DepartmentController");
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
		LOGGER.info("Inside deleteDepartmentById of DepartmentController");
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId, @RequestBody Department department) {
		LOGGER.info("Inside updateDepartment of DepartmentController");
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentsByName(@PathVariable("name") String departmentName) {
		LOGGER.info("Inside fetchDepartmentsByName of DepartmentController");
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
