package com.project.aopdemo.dao;

import java.util.List;

import com.project.aopdemo.Account;

public interface AccountDAO {
	void addAccount(Account theAccount, boolean vipFlag);

	boolean doWork();

	public String getName();

	public void setName(String name);

	public String getServiceCode();

	public void setServiceCode(String serviceCode);
	
	//add a new method : findAccounts()
	public List<Account> findAccounts();

	List<Account> findAccounts(boolean tripWire);
}
