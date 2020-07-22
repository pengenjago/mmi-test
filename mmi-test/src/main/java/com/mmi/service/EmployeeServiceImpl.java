package com.mmi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmi.dao.EmployeeDao;
import com.mmi.dto.EmployeeDto;
import com.mmi.exception.ResourceNotFound;
import com.mmi.model.Employee;
import com.mmi.model.Position;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<EmployeeDto> findAll(Example<Employee> example, Pageable pageable) {
		try {
			Page<Employee> all = dao.findAll(example, pageable);
			List<EmployeeDto> dtos = new ArrayList<>();

			for (Employee data : all.getContent()) {
				EmployeeDto dto = modelMapper.map(data, EmployeeDto.class);

				dtos.add(dto);
			}

			return new PageImpl<>(dtos, pageable, all.getTotalElements());
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public EmployeeDto byId(Integer id) {
		Optional<Employee> data = dao.findById(id);
		
		EmployeeDto dto = modelMapper.map(data.get(), EmployeeDto.class);
		
		return dto;
	}

	@Override
	public EmployeeDto create(EmployeeDto param) {
		Employee data = modelMapper.map(param, Employee.class);
		data.setIsDelete(0);
		
		return byId(dao.save(data).getId());
	}

	@Override
	public EmployeeDto update(Integer id, EmployeeDto param) {
		try {
			Employee data = dao.findById(id).orElseThrow(() -> new ResourceNotFound(id));
			
			data.setName(param.getName());
			data.setGender(param.getGender());
			data.setBirthDate(param.getBirthDate());
			data.setPosition(new Position(param.getPositionId()));
			data.setIdNumber(param.getIdNumber());
			
			return byId(dao.save(data).getId());
		}catch (ResourceNotFound e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Employee data = dao.findById(id).orElseThrow(() -> new ResourceNotFound(id));
			
			data.setIsDelete(1);
			dao.save(data);
			
		}catch (ResourceNotFound e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
