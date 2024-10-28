package com.project.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(* com.project.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create a poincut for getter methods
	@Pointcut("execution(* com.project.aopdemo.dao.*.get*(..))")
	public void getter() {
	}
 
	// create a poincut for getter methods
	@Pointcut("execution(* com.project.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create pointcut include package.. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
