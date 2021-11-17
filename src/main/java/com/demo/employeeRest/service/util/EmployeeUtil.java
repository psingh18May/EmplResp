package com.demo.employeeRest.service.util;

import com.demo.employeeRest.dto.EmployeeDto;
import com.demo.employeeRest.entity.EmployeeEntity;

public class EmployeeUtil {
	
	public static EmployeeDto employeeEntityToDto(EmployeeEntity entity) {
		String firstName = entity.getFirstName();
		String lastName = entity.getLastName();
		String email = entity.getEmail();
		long id = entity.getId();
		EmployeeDto dto = new EmployeeDto(id,firstName, lastName, email);
		return dto;
	}

	
	public static EmployeeEntity employeeDtoToEntity(EmployeeDto dto) {
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		String email = dto.getEmail();
		long id = dto.getId();
		EmployeeEntity entity = new EmployeeEntity(id, firstName, lastName, email);
		return entity;
	}
}
