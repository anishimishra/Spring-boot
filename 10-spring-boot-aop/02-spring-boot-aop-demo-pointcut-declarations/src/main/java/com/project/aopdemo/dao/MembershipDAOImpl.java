package com.project.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
	@Override
	public boolean addSillyMember() {
		System.out.println(getClass() + ": Doing my DB work: adding a membership");
		return true;
	}

	@Override
	public void goToSleep() {
		System.out.println(getClass() + ": Im going to sleep");
	}

}
