package com.miit.hibernateTraining;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT_ONE_TO_MANY")
public class DepartmentOneToMany implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	//@OneToMany(mappedBy = "department")
	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Set<EmployeeOneToMany> employees;

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

	public Set<EmployeeOneToMany> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeOneToMany> employees) {
		this.employees = employees;
	}
}
