package com.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gradez" )
public class Grade {
	
	 private String grade;
	 private int grade_id;
	 private Course courseG;
	 private Student studentG;
		

	public Grade(Course courseG, Student studentG) {
		super();
		this.courseG = courseG;
		this.studentG = studentG;
	}

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "grade")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_id")
	public int getGrade_id() {
		return grade_id;
	}
	
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourseG() {
		return courseG;
	}

	public void setCourseG(Course courseG) {
		this.courseG = courseG;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudentG() {
		return studentG;
	}

	public void setStudentG(Student studentG) {
		this.studentG = studentG;
	}

	
	
}
