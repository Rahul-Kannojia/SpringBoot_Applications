package com.app.jpaDemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.jpaDemo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
