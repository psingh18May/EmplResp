package com.demo.employeeRest.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.employeeRest.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
