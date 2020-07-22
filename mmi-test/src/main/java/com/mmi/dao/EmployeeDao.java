package com.mmi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.mmi.model.Employee;

public interface EmployeeDao extends PagingAndSortingRepository<Employee, Integer>, QueryByExampleExecutor<Employee>{

}
