package com.project.springboot.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	// add support for jdbc
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		// define query to retrieve a user by username
		theUserDetailsManager.setUsersByUsernameQuery("select user_id, pw,active from members where user_id=?");
		// define query to retrieve the authorities/roles by username
		theUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		return theUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
				.requestMatchers("/leaders/**").hasRole("MANAGER").requestMatchers("/systems/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				// Add logout support
				.logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
		return http.build();
	}
}
