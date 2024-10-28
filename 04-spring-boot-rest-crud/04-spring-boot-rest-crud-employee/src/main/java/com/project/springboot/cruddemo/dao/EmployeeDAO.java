package com.project.springboot.cruddemo.dao;

import java.util.List;

import com.project.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
}
