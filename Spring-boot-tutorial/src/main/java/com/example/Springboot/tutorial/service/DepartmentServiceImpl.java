package com.example.Springboot.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Springboot.tutorial.entity.Department;
import com.example.Springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department); //this save() method is from the JpaRepository that we extended in departmentRepository class
	}
	
}
