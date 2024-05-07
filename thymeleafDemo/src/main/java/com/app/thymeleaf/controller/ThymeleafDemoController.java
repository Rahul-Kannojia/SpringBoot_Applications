package com.app.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.app.thymeleaf.model.Student;

@Controller
public class ThymeleafDemoController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "index";
	}

	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");//data.html
		mav.addObject("message","Take one idea and change your life and carrer !!");
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudentObject() {
		ModelAndView mav = new ModelAndView("student");// student.html
		Student std = new Student();
		std.setName("Rahul");
		std.setScore(70);
		mav.addObject("Student",std);
		return mav;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");// student.html
		Student std1 = new Student();
		std1.setName("Rahul");
		std1.setScore(70);
		
		Student std2 = new Student();
		std2.setName("Shweta");
		std2.setScore(75);
		
		List<Student> stdList = Arrays.asList(std1,std2);
		mav.addObject("students",stdList);
		return mav;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView getStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");// student.html
		//Student std = new Student();
		mav.addObject("student",new Student());
		return mav;
	}
	
	@PostMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");// student.html
		System.out.println(student.getName());
		System.out.println(student.getScore());
		mav.addObject("student",student);
		return mav;
	}
}
