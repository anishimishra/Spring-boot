package com.project.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.springcoredemo.common.Coach;
import com.project.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
