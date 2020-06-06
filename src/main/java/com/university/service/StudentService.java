package com.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.dao.StudentDAO;
import com.university.model.Course;
import com.university.model.Student;

@Service("studentService")
@Transactional
public class StudentService {
 
 StudentDAO studentDao;
 
 @Autowired
 public void setStudentDao(StudentDAO studentDao) {
  this.studentDao = studentDao;
 }

public List<Student> listAllStudents() {
	  return studentDao.listAllStudents();
}

public void saveOrUpdate(Student student) {
	  studentDao.saveOrUpdate(student);	
}

public Student findStudentById(int id) {
	  return studentDao.findStudentById(id);
}

public void deleteStudent(int id) {
	  studentDao.deleteStudent(id);	
}

public boolean verifyStudent(String email, String password) {
	Student student = studentDao.findStudentByemail(email, password);
	if(student!=null)
	return true;
	else 
	return false;
}

public Student findStudentByemail(String email, String password) {
	return studentDao.findStudentByemail(email, password);	 
}

public List<Course> Studentcourselist(int id) {
	return studentDao.Studentcourselist(id);			
}


}