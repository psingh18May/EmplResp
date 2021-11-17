package com.demo.employeeRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeeRest.dto.EmployeeDto;
import com.demo.employeeRest.service.EmployeeService;

@RestController
@RequestMapping(path ="/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id) {
		EmployeeDto employee = service.getEmployeeById(id);
		Optional<EmployeeDto> opt = Optional.of(employee);
		if(opt.isPresent()) {
			return  ResponseEntity.ok(opt.get());
		}
		else {
			return new ResponseEntity<EmployeeDto>(HttpStatus.NOT_FOUND);
		}

	}

	
	@PostMapping
	public long addEmployee(@RequestBody EmployeeDto dto) {
		return service.insertEmployee(dto);
	}
	
	@GetMapping
	public List<EmployeeDto> getAllEmployees(){
		return service.getAllEmployee();
	}
}
