package com.example.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{ //extends JpaRepository bc this has methods we can use to interact our entity with db
//Need to pass the entity and primary key type (Long bc department id is our PK) to JpaRepository  
	
	//To find supported key words when creating custom methods and having JPA figuring out logic for you, google spring boot query creation
	public Department findByDepartmentName(String departmentName); //naming convention important. Need to start w/ findBy and then name of field, departmentName as written in Department class but w/ capital D in department
	public Department findByDepartmentNameIgnoreCase(String departmentName); //These method logic will automatically be created by JPA. Just add IngoreCase w/ specified field at the end of method name.

}
