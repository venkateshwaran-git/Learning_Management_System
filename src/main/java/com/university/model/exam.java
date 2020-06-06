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
@Table(name = "examz" )
public class exam {
	
	 private int exam_id;
	 private String name;
	 private int mark;
	 private int totalmark;
	 private Course course_E;
	 private Student student_E;
	 
	public exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public exam(int exam_id, String name, int mark, int totalmark, Course course_E, Student student_E) {
		super();
		this.exam_id = exam_id;
		this.name = name;
		this.mark = mark;
		this.totalmark = totalmark;
		this.course_E = course_E;
		this.student_E = student_E;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_id")
	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	@Column(name = "mark")
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Column(name = "totalmark")
	public int getTotalmark() {
		return totalmark;
	}

	public void setTotalmark(int totalmark) {
		this.totalmark = totalmark;
	}
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse_E() {
		return course_E;
	}

	public void setCourse_E(Course course_E) {
		this.course_E = course_E;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent_E() {
		return student_E;
	}

	public void setStudent_E(Student student_E) {
		this.student_E = student_E;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	 
}
