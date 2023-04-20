package com.miit.training.inheritance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_TABLE_PER_SUB_CLASS")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class EmployeeTablePerSubClass extends PersonTablePerSubClass {

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public EmployeeTablePerSubClass() {
	}
	
	public EmployeeTablePerSubClass(String firstname, String lastname, String departmentName, Date joiningDate) {
		
		super(firstname, lastname);
		
		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
