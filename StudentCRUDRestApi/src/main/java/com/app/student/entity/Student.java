package com.app.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students",schema = "rahuldb")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollno;
	@Column(name="student_name")
	private String name;
	@Column(name="student_branch")
	private String branch;
	@Column(name="student_percentage")
	private Double percentage;
	
}
