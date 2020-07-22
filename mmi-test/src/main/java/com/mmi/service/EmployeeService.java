package com.mmi.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmi.dto.EmployeeDto;
import com.mmi.model.Employee;

public interface EmployeeService {
	Page<EmployeeDto> findAll(Example<Employee> example, Pageable pageable);
	EmployeeDto byId(Integer id);
	EmployeeDto create(EmployeeDto param);
	EmployeeDto update(Integer id, EmployeeDto param);
	void delete(Integer id);
}
