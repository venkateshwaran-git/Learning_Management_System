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
@Table(name = "appointment" )
public class Appointment {

	 private int appointment_id;
	 private String begin_at;
	 private String end_at;
	 private String appointment_date;
	 private String appointment_status;
	 private String link;
	 private Student student_App;
	 private Course course_App;
	 
	 
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(int appointment_id, String begin_at, String end_at, String appointment_date, String appointment_status,
			Student student_App, Course course_App) {
		super();
		this.appointment_id = appointment_id;
		this.begin_at = begin_at;
		this.end_at = end_at;
		this.appointment_date = appointment_date;
		this.appointment_status = appointment_status;
		this.student_App = student_App;
		this.course_App = course_App;
	}

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "appointment_id")
	public int getAppointment_id() {
		return appointment_id;
	}


	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	 @Column(name = "begin_at")
	public String getBegin_at() {
		return begin_at;
	}


	public void setBegin_at(String begin_at) {
		this.begin_at = begin_at;
	}

	 @Column(name = "end_at")
	public String getEnd_at() {
		return end_at;
	}


	public void setEnd_at(String end_at) {
		this.end_at = end_at;
	}

	 @Column(name = "appointment_date")
	public String getAppointment_date() {
		return appointment_date;
	}


	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	 @Column(name = "appointment_status")
	public String getAppointment_status() {
		return appointment_status;
	}


	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent_App() {
		return student_App;
	}


	public void setStudent_App(Student student_App) {
		this.student_App = student_App;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse_App() {
		return course_App;
	}


	public void setCourse_App(Course course_App) {
		this.course_App = course_App;
	}

	@Column(name = "link")
	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	 	
}
