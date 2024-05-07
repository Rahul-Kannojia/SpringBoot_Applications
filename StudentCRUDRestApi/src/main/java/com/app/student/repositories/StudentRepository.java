package com.app.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
