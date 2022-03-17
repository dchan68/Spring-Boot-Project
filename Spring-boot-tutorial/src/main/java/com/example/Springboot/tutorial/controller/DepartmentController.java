package com.example.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot.tutorial.entity.Department;
import com.example.Springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {//will be passing request body since post is creating data. Will convert json data into our entity, which is Department, for our request
		//DepartmentService service = new DepartmentServiceImpl(); Spring boot already knows we have these class/ interface already created & knows these particular class are in our container. If someone else, spring can automatically
		//provide them. Therefore user doesn't have to create them on their own, hence they're commented out. Can implement by using @Autowired
		return departmentService.saveDepartment(department);
	}
}
