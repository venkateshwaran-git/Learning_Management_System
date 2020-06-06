package com.university.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendanze" )
public class Attendance {
	
	private int attendance_id;
	private Boolean present;
	private Date date;
	private Student student_A;
	private Course course_A;
	
	
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance( Boolean present, Date date, Student student_A, Course course_A) {
		super();
		this.present = present;
		this.date = date;
		this.student_A = student_A;
		this.course_A = course_A;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	@Column(name = "present")
	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent_A() {
		return student_A;
	}

	public void setStudent_A(Student student_A) {
		this.student_A = student_A;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse_A() {
		return course_A;
	}

	public void setCourse_A(Course course_A) {
		this.course_A = course_A;
	}
	
}
