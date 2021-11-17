package com.demo.employeeRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class EmployeeEntity {
	
	@Id
	@Column(name ="employee_id")
	private  long id;
	
	@Column(name = "employee_first_name" , nullable = false)
	private  String firstName;
	
	@Column(name = "employee_last_name", nullable = false)
	private  String lastName;
	
	@Column(name = "employee_email" , unique = true, nullable = false,updatable = false)
	private  String email;
	

	public EmployeeEntity( long id,String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}
	

	public EmployeeEntity() {
		super();
	}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}
	
	

}
