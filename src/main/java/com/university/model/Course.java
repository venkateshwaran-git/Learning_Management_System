package com.university.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "course" )
public class Course {
	
	 private int course_id;
	 
	 @Pattern(regexp = "(^[a-z A-Z]+$)", message = "Only alphabets allowed")
	 @NotNull(message = "Please enter the Course name.")
	 private String name;
	 
	 @NotEmpty(message = "Please enter the classroom.")
	 private String classroom;
	 
	 @NotEmpty(message = "Please enter the class timings.")
	 private String timings;
	 
	 @Digits(integer=1, fraction=0, message = "Only single Digit credits allowed")
	 @NotNull(message = "Please select your course credit.")
	 private int credits;
	 
	 @Digits(integer=2, fraction=0, message = "Max capacity 99 allowed")
	 @NotNull(message = "Please enter the capacity.")
	 private int capacity;
	 
	 private Teacher teacher1; 
	 private List<Student> students = new ArrayList<Student>();


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(int course_id, String name, String classroom, String timings, int credits, int capacity,
			Teacher teacher1, List<Student> students, List<Grade> grades) {
		super();
		this.course_id = course_id;
		this.name = name;
		this.classroom = classroom;
		this.timings = timings;
		this.credits = credits;
		this.capacity = capacity;
		this.teacher1 = teacher1;
		this.students = students;
	}


	@ManyToMany(mappedBy = "courses") 
	public List<Student> getStudents() {
			return students;
		}

	public void setStudents(List<Student> students) {
			this.students = students;
		}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "course_id")
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "classroom")
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@Column(name = "Timings")
	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	@Column(name = "credits")
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Column(name = "capacity")
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@ManyToOne
	 @JoinColumn(name = "teacher_id")
	public Teacher getTeacher1() {
		return teacher1;
	}

	public void setTeacher1(Teacher teacher1) {
		this.teacher1 = teacher1;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", classroom=" + classroom + ", timings=" + timings
				+ ", credits=" + credits + ", capacity=" + capacity + ", teacher1=" + teacher1 + ", students="
				+ students + "]";
	}

	
	
	 
}
