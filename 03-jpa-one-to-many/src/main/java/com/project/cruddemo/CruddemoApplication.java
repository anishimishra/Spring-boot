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

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesforInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// findInstructorWithCoursesJoinFetchInstructorDetail(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		System.out.println("deleting the course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("deleting the instructor id" + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		// find the course
		System.out.println("finding the course " + theId);
		Course tempCourse = appDAO.findCourseById(theId);
		System.out.println(tempCourse);
		// setting the course id
		System.out.println("setting the course");
		tempCourse.setTitle("Enjoy the Simple Things");
		// updating the course title
		appDAO.update(tempCourse);
		System.out.println("done");
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		// find the instructor
		System.out.println("finding the instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstuctorById(theId);
		// update the instructor
		System.out.println("updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
		System.out.println("done");
	}

	private void findInstructorWithCoursesJoinFetchInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		// find the instructor
		System.out.println("finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetchInstructorDetails(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		// find the instructor
		System.out.println("finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
	}

	private void findCoursesforInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		// find instructor
		System.out.println("finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstuctorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		// find courses for instructor
		System.out.println("finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		// associate the objects
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstuctorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Public", "sus@mail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will also save the courses
		// because of CascadeType.PERSIST
		System.out.println("saving instructor: " + tempInstructor);
		System.out.println("the courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("done");
	}
}
