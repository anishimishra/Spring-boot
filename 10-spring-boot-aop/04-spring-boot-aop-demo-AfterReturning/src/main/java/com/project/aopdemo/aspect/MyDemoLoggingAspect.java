package com.project.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.project.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@After("execution(* com.project.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(pointcut = "execution(* com.project.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>> Executing @AfterThrowing on method: " + method);
		// log the properties
		System.out.println("\n=======>>>> exception is: " + theExc);
	}

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.project.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>> Executing @AfterReturning on method: " + method);
		// print out the results of the method call
		System.out.println("\n=======>>>> result: " + result);
		// lets post process the data, lets modify it
		// convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		// loop through the accounts
		for (Account account : result) {
			// get uppercase version of name
			// update the name on the account
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.project.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSignature);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();
		// loop through the args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
}