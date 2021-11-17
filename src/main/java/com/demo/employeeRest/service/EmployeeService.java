package com.demo.employeeRest.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.employeeRest.dto.EmployeeDto;
import com.demo.employeeRest.entity.EmployeeEntity;
import com.demo.employeeRest.repository.EmployeeRepository;
import com.demo.employeeRest.service.util.EmployeeUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public EmployeeDto getEmployeeById(long id) {
		EmployeeEntity employee = repository.findById(id).get();
		return EmployeeUtil.employeeEntityToDto(employee);
	}
	
	
	public List<EmployeeDto> getAllEmployee(){
		List<EmployeeEntity> entityList = (List<EmployeeEntity>) repository.findAll();
		return	entityList.stream().map(employee -> EmployeeUtil.employeeEntityToDto(employee)).collect(Collectors.toList());
	}
	
	@Transactional()
	public long insertEmployee(EmployeeDto employee) {
		Optional<EmployeeEntity> entity = repository.findById(employee.getId());
		if(entity.isEmpty()) {
		repository.save(EmployeeUtil.employeeDtoToEntity(employee));
		return employee.getId();
		}
		else {
			throw new ConstraintViolationException("duplicate record", new SQLException(), "primary key exist");
		}
	}
	
	
	
	
}
