package com.project.cruddemo.dao;

import java.util.List;

import com.project.cruddemo.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);

	Student findById(Integer id);

	List<Student> findAll();

	List<Student> findOrderByLastName();

	List<Student> findByLastName(String theLastName);

	void update(Student theStudent);

	void deleteById(Integer id);

	int DeleteAll();
}
