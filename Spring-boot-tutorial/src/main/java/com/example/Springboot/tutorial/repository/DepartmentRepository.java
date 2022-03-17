package com.example.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{ //extends JpaRepository bc this has methods we can use to interact our entity with db
//Need to pass the entity and primary key type (Long bc department id is our PK) to JpaRepository  
	
}
