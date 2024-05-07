package com.app.jpaDemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.jpaDemo.entities.Student;
import com.app.jpaDemo.repos.StudentRepository;

@SpringBootTest
class SpringBootDataJpaRkApplicationTests {

	@Autowired
	private StudentRepository studentrepository;
	
	@Test
	public void saveStudentTest() {
		Student s= new Student();
		s.setSid(1l);
		s.setSname("Rahul");
		s.setTestScore(75);
		studentrepository.save(s);
		System.out.println("Check::"+studentrepository.findById(1l).isPresent());
		Student savedStudent=studentrepository.findById(s.getSid()).get();
		assertNotNull(savedStudent);
	}

}
