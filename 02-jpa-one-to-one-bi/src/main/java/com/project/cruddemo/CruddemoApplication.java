package com.project.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.cruddemo.dao.AppDAO;
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
			createInstructor(appDAO);
			// findInstructorById(appDAO);
			// deleteInstructorById(appDAO);
			// findInstructorDetailById(appDAO);
			// deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 3;
		System.out.println("deleting instructor detail id: " + theId);
		appDAO.deleteInstuctorDetailById(theId);
		System.out.println("done");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("finding instructor id: " + theId);
		// get the instructor detail object
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println(tempInstructorDetail);
		// print the associated instructor
		System.out.println(tempInstructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("deleting instructor id: " + theId);
		appDAO.deleteInstuctorById(theId);
		System.out.println("done");
	}

	private void findInstructorById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstuctorById(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		 * // create the instructor Instructor tempInstructor = new
		 * Instructor("Chad","Darby", "dar@mail.com");
		 * 
		 * // create the instructor detail InstructorDetail tempInstructorDetail = new
		 * InstructorDetail("http://you", "youtbe");
		 * 
		 */

		// create the instructor
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "mad@mail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://you", "guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("done");
	}
}
