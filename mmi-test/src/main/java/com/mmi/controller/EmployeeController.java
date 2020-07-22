package com.mmi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmi.dto.EmployeeDto;
import com.mmi.model.Employee;
import com.mmi.service.EmployeeService;


@RestController
@RequestMapping("/mmi")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public Page<EmployeeDto> getAll(Pageable pageable, Employee path) throws Exception {
		try {
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withIgnorePaths("id")
					.withIgnoreCase().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
			Example<Employee> example = Example.of(path, matcher);

			return empService.findAll(example, pageable);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/employee")
	public EmployeeDto create(@RequestBody @Valid EmployeeDto param) throws Exception {
		try {
			return empService.create(param);
		}catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/employee/{id}")
	public EmployeeDto update(@PathVariable("id") int id, @RequestBody @Valid EmployeeDto param) throws Exception {
		try {
			return empService.update(id, param);
		}catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable("id") int id) throws Exception {
		try {
			empService.delete(id);
			
			return "Sukses";
		}catch (Exception e) {
			throw e;
		}
	}
}
