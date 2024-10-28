package com.project.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cruddemo.entity.Course;
import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {
	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public AppDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		entityManager.persist(theInstructor);
	}

	// this (the below method) will also retrieve the instructor details object
	// because of default behavior of @OneToOne fetch type is eager
	@Override
	public Instructor findInstuctorById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstuctorById(int theId) {
		// TODO Auto-generated method stub
		// retrieve the instructor
		Instructor instructor = entityManager.find(Instructor.class, theId);
		// delete the instructor
		entityManager.remove(instructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstuctorDetailById(int theId) {
		// TODO Auto-generated method stub
		// retrieve the instructor detail
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);

		// remove the associated object reference
		// break bi-directional link
		instructorDetail.getInstructor().setInstructorDetail(null);

		// delete the instructor
		entityManager.remove(instructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		// TODO Auto-generated method stub
		// create query
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
		query.setParameter("data", theId);
		// execute query
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query = entityManager.createQuery(
				"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id = :data", Instructor.class);
		query.setParameter("data", theId);
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	public Instructor findInstructorByIdJoinFetchInstructorDetails(int theId) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "JOIN FETCH i.courses "
				+ "JOIN FETCH i.instructorDetail " + "where i.id = :data", Instructor.class);
		query.setParameter("data", theId);
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		// TODO Auto-generated method stub
		entityManager.merge(tempInstructor);
	}

	@Override
	@Transactional
	public void update(Course tempCourse) {
		// TODO Auto-generated method stub
		entityManager.merge(tempCourse);
	}

	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub

		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		// get the courses
		List<Course> courses = tempInstructor.getCourses();

		// break association of all courses for the instructor
		for (Course course : courses) {
			course.setInstructor(null);
		}

		// delete the instructor
		entityManager.remove(tempInstructor);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		Course tempCourse = entityManager.find(Course.class, theId);
		entityManager.remove(tempCourse);
	}

	@Override
	@Transactional
	public void save(Course theCourse) {
		// TODO Auto-generated method stub
		entityManager.persist(theCourse);
	}

	@Override
	public Course findCourseAndReviewsByCourseId(int theId) {
		// TODO Auto-generated method stub
		// create query
		TypedQuery<Course> query = entityManager
				.createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "where c.id= :data", Course.class);
		query.setParameter("data", theId);
		// execute query
		Course course = query.getSingleResult();
		return course;
	}
}
