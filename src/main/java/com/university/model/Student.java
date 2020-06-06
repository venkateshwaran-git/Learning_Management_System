package com.university.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "studentz")
public class Student {

	 private int student_id;
	 
	 @Pattern(regexp = "(^[a-zA-Z]+$)", message = "Only alphabets allowed")
	 @NotNull(message = "Please enter your firstname.")
	 private String firstname; 
	 
	 @Pattern(regexp = "(^[a-zA-Z]+$)", message = "Only alphabets allowed")
	 @NotNull(message = "Please enter your lastname.")
	 private String lastname; 
	 
	 @NotNull(message = "Please choose your Gender.")
	 private String gender; 
	 
	 @NotBlank(message = "Please enter your Address.")
	 private String address; 
	 	 
	 @Pattern(regexp = "(([\\w\\.]+)@([\\w\\.]+)\\.(\\w+))", message = "Please enter valid Email.")
	 @NotNull(message = "Please enter your Email.")
	 private String email;	
	 
	 @NotNull(message = "Please enter your password.")
	 @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	 private String password; 
	 
	 private List<Course> courses = new ArrayList<Course>();


	 public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Student(int student_id, String firstname, String lastname, String gender, String address, String email,
			String password, List<Course> courses, List<Grade> grades_s) {
		super();
		this.student_id = student_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.password = password;
		this.courses = courses;
	}


	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "student_id")
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	 @Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	 @Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManyToMany
    @JoinTable(
        name = "studentz_course", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
