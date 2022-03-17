package com.example.Springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //This annotation is used to make this class an entity to interact with our DB using the JPA
public class Department {
	
	@Id //Table has primary key so this annotation will create our primary key. Will make departmentId as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //will generate our primary key
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	public Department() {
		super();
	}
	
	public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	
	public String getDepartmentCode() {
		return departmentCode;
	}
	
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
	
	
}
