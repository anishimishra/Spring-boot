package com.project.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.cruddemo.dao.AppDAO;
import com.project.cruddemo.entity.Course;
import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;
import com.project.cruddemo.entity.Review;
import com.project.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			// findStudentAndCourses(appDAO);
			// addMoreCoursesForStudent(appDAO);
			// deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("deleting student id: " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("done");
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("done");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);
		System.out.println("loaded student: " + tempStudent);
		System.out.println("courses: " + tempStudent.getCourses());
		System.out.println("done");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
		System.out.println("done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub

		// create a course
		Course tempCourse = new Course("Pacman - How to score 1M Points");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@mail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@mail.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("saving the course: " + tempCourse);
		System.out.println("associated student: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("done");
	}

}
