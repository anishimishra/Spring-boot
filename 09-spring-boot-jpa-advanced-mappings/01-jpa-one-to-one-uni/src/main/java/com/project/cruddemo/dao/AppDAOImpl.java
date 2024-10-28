package com.project.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;

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

}
