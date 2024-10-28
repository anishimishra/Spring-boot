package com.project.cruddemo.dao;

import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;

public interface AppDAO {
	void save(Instructor theInstructor);

	// this (the below method) will also retrieve the instructor details object
	// because of default behavior of @OneToOne fetch type is eager
	Instructor findInstuctorById(int theId);

	// this will also delete the instructor details object
	// because of CascadeType.ALL
	void deleteInstuctorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	// this will also delete the instructor object
	// because of CascadeType.ALL
	void deleteInstuctorDetailById(int theId);
}
