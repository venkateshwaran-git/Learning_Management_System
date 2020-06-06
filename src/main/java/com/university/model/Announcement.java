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
@Table(name = "announcementz" )
public class Announcement {
	
	private int announcement_id;
	private Course course_An;
	private String announcement;
	
	
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Announcement(int announcement_id, Course course_An, String announcement) {
		super();
		this.announcement_id = announcement_id;
		this.course_An = course_An;
		this.announcement = announcement;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "announcement_id")
	public int getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}

	@Column(name = "announcement")
	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse_An() {
		return course_An;
	}

	public void setCourse_An(Course course_An) {
		this.course_An = course_An;
	}
	
}
