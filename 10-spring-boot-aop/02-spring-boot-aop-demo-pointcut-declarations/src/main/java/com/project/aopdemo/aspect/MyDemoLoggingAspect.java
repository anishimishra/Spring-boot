package com.project.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* com.project.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create a poincut for getter methods
	@Pointcut("execution(* com.project.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create a poincut for getter methods
	@Pointcut("execution(* com.project.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut include package.. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalysis() {
		System.out.println("\n=====>>> Performing API analytics");
	}

}
