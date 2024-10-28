package com.project.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.aopdemo.dao.AccountDAO;
import com.project.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			demoTheAfterAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulates exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\nMain program: caught exception "+exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulates exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\nMain program: caught exception "+exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

}
