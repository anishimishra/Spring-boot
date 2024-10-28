package com.project.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

	@Value("${countries}")
	private List<String> countries;

	@Value("${languages}")
	private List<String> languages;
	
	@Value("${operatingSystems}")
	private List<String> operatingSystems;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("student", theStudent);

		// add the list of countries to the model
		theModel.addAttribute("countries", countries);

		// add the list of languages to the model
		theModel.addAttribute("languages", languages);
		
		// add the list of operating systems to the model
		theModel.addAttribute("operatingSystems", operatingSystems);

		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " of country "
				+ theStudent.getCountry() + " with favourite language " + theStudent.getFavouriteLanguage());
		List<String> operatingSystems = theStudent.getFavouriteSystems();
		System.out.println("Favourtie Operating Systems: ");
		for (String operatingSystem : operatingSystems) {
			System.out.print(operatingSystem + ", ");
		}
		System.out.println();
		return "student-confirmation";
	}
}
