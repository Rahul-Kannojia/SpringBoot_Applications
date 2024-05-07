package com.app.jpaDemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	
	@Id
	@GeneratedValue//(strategy= GenerationType.AUTO)
	private Long sid;
	
	@Column(name="student_name")
	private String sname;
	
	private int testScore;

	public Long getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	
}
