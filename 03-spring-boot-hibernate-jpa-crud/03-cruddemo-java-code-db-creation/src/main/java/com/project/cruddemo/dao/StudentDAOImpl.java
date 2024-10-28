package com.project.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		System.out.println("in constructor of: " + getClass().getSimpleName());
		this.entityManager = entityManager;
	}

	// implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		System.out.println("inside save method");
		entityManager.persist(theStudent);
	}

	// implement the findById method
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub

		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

		// return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findOrderByLastName() {
		// TODO Auto-generated method stub
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub

		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

		// set query parameters
		theQuery.setParameter("theData", theLastName);

		// return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

		// retrieve the student
		Student theStudent = entityManager.find(Student.class, id);

		// delete the student
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int DeleteAll() {
		// TODO Auto-generated method stub
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

}
