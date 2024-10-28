package com.project.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private String name;
	private String serviceCode;

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: adding an account");
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCodes()");
		this.serviceCode = serviceCode;
	}

	/*@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		List<Account> myAccounts = new ArrayList<>();
		// create sample accounts
		Account temp1 = new Account("John", "silver");
		Account temp2 = new Account("madhu", "platinum");
		Account temp3 = new Account("luke", "gold");
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;
	}*/
	
	@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		// TODO Auto-generated method stub
		//for academic purposes.. simulate an exception
		if(tripWire) {
			throw new RuntimeException("no soup for you");
		}
		List<Account> myAccounts = new ArrayList<>();
		// create sample accounts
		Account temp1 = new Account("John", "silver");
		Account temp2 = new Account("madhu", "platinum");
		Account temp3 = new Account("luke", "gold");
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;
	}
}
