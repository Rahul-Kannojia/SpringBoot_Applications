package com.app.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.student.entity.Student;
import com.app.student.repositories.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;

	//Get all the students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students = studentRepo.findAll();
		return students;
	}
	
	@GetMapping("/student/{sid}")
	public Student getStudentById(@PathVariable("sid") Integer rollno) {
		Student student = studentRepo.findById(rollno).get();
		return student;
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}
	
	@PutMapping("/student/update/{sid}")
	public Student updateStudent(@PathVariable("sid") Integer rollno) {
		Student student = studentRepo.findById(rollno).get();
		student.setName("Neha");
		student.setPercentage(71.00);
		studentRepo.save(student);
		return student;
	}
	
	@PatchMapping("/update/add")
	public Student updateStudentPartially(@RequestBody Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}
	
	@DeleteMapping("/student/deleteById/{sid}")
	public void deleteStudentWithId(@PathVariable("sid") Integer rollno) {
		studentRepo.deleteById(rollno);
	}
	
	@DeleteMapping("/student/delete/{sid}")
	public void deleteStudent(@PathVariable("sid") Integer rollno) {
		Student student = studentRepo.findById(rollno).get();
		studentRepo.delete(student);
	}
}


