package com.project.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.cruddemo.dao.StudentDAO;
import com.project.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		System.out.println("inside main");
		SpringApplication.run(CruddemoApplication.class, args);
		System.out.println("below main line");
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("inside runner");
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentOrderByLastName(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudentById(studentDAO);
			deleteAllStudents(studentDAO);
			System.out.println("below runner line");
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all students");
		int i = studentDAO.DeleteAll();
		System.out.println("Deleted row count " + i);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studentId = 4;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.deleteById(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student..");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student" + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudentOrderByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> student = studentDAO.findOrderByLastName();
		for (Student student2 : student) {
			System.out.println(student2);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student stu : theStudents) {
			System.out.println(stu);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		// create a student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@mail.com");

		// save the student
		System.out.println("saving the student..");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Student saved. Id generated: " + theId);

		// retrieve the student
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// create multiple students
		System.out.println("creating 3 students object...");
		Student tempStudent1 = new Student("John", "Doe", "john@mail.com");

		System.out.println("creating new student object...");
		Student tempStudent2 = new Student("Mary", "Public", "mary@mail.com");

		System.out.println("creating new student object...");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@mail.com");

		// save the student objects
		System.out.println("saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// create the student object
		System.out.println("creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@mail.com");
		// save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}