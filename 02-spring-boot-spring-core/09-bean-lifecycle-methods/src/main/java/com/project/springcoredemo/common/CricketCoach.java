package com.project.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	// define our init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("in doMyStartupStuff(): " + getClass().getSimpleName());
	}

	// define our destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("in doMyCleanupStuff() method: " + getClass().getSimpleName());
	}
}
