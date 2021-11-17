package com.demo.employeeRest.dto;

public class EmployeeDto {
	
	private final long id;
	
	private final String firstName;
	
	private final String lastName;
	
	private final String email;
	

	public EmployeeDto( long id,String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
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
