package com.project.aopdemo.dao;

import com.project.aopdemo.Account;

public interface AccountDAO {
	void addAccount(Account theAccount, boolean vipFlag);

	boolean doWork();
}
