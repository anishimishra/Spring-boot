package com.project.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() {
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return a fortune
		return "Expect heavy traffic this morning";
	}

	@Override
	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major aCCIDENT HIGHWAY IS CLOSED");
		}
		return getFortune();
	}

}
