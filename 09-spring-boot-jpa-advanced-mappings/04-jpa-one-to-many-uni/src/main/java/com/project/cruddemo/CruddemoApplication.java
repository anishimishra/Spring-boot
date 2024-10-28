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

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		System.out.println("deleting the course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		// print the course
		System.out.println(tempCourse);
		// print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// create a course
		Course tempCourse = new Course("Pacman - How to score 1M Points");
		// add some reviews
		tempCourse.addReview(new Review("Great course.. loved it"));
		tempCourse.addReview(new Review("Cool course.. job well done"));
		tempCourse.addReview(new Review("what a dumb course, you are an idiot"));
		// save the course and leverage the cascade all
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done");
	}

}
