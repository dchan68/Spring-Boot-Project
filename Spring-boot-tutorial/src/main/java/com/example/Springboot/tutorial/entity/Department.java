package com.example.Springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //This annotation is used to make this class an entity to interact with our DB using the JPA
//@Data //Comes from lombok dependency and plugin and will replace all the arg constructors, getters/setters, toString
//@NoArgsConstructor //Also from lombok, which takes care of no argument constructor
//@AllArgsConstructor //Also from lombok
@Builder
public class Department {
	
	@Id //Table has primary key so this annotation will create our primary key. Will make departmentId as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //will generate our primary key
	private Long departmentId;
	
	//Annotation below is Part of hibernate validation
	@NotBlank(message = "Please add department name")//Will make departmentName a mandatory requirement. Without this, will not be valid request if want to create department. DepartmentName is the min requirement
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	

//Can Commented all codes below this out since lombok will do this with less code using annotation @Data, @NoArgsConstructor, @AllArgsConstuctor	
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
	
	public Department(String departmentName, String departmentAddress, String departmentCode) {
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
