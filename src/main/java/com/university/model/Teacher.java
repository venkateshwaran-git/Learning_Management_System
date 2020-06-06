package com.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacherz")
public class Teacher {
	
	 private int teacher_id;
	 
	 @Pattern(regexp = "(^[a-zA-Z]+$)", message = "Only alphabets allowed")
	 @NotNull(message = "Please enter your firstname.")
	 private String firstname;
	 
	 @Pattern(regexp = "(^[a-zA-Z]+$)", message = "Only alphabets allowed")
	 @NotNull(message = "Please enter your lastname.")
	 private String lastname;	
	 
	 @Pattern(regexp = "(([\\w\\.]+)@([\\w\\.]+)\\.(\\w+))", message = "Please enter valid Email.")
	 @NotNull(message = "Please enter your Email.")
	 private String email;	 
	 
	 @NotNull(message = "Please enter your password.")
	 @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	 private String password;	
	 	 
	 
	 public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public Teacher(int teacher_id, String firstname, String lastname, String email, String password) {
		super();
		this.teacher_id = teacher_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "teacher_id")
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
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

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + "]";
	}

	

}
