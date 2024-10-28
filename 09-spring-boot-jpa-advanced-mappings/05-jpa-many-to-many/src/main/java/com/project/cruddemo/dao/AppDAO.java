package com.project.cruddemo.dao;

import java.util.List;

import com.project.cruddemo.entity.Course;
import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;
import com.project.cruddemo.entity.Student;

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

	List<Course> findCoursesByInstructorId(int theId);

	Instructor findInstructorByIdJoinFetch(int theId);

	Instructor findInstructorByIdJoinFetchInstructorDetails(int theId);

	void update(Instructor tempInstructor);

	void update(Course tempCourse);

	Course findCourseById(int theId);

	void deleteInstructorById(int theId);

	void deleteCourseById(int theId);

	void save(Course theCourse);

	Course findCourseAndReviewsByCourseId(int theId);

	Course findCourseAndStudentsByCourseId(int theId);

	Student findStudentAndCourseByStudentId(int theId);

	void update(Student tempStudent);

	void deleteStudentById(int theId);
}
