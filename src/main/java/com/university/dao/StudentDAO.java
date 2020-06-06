package com.university.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.model.Course;
import com.university.model.Student;

@Repository("studentDao")
public class StudentDAO {

 @Autowired
 private SessionFactory sessionFactory;

 protected Session getSession(){
  return sessionFactory.getCurrentSession();
 }

@SuppressWarnings("unchecked")
public List<Student> listAllStudents() {
	Criteria criteria = getSession().createCriteria(Student.class);
	  return (List<Student>) criteria.list();
}

public void saveOrUpdate(Student student) {
	getSession().saveOrUpdate(student);
}

public Student findStudentById(int id) {
	Student student = (Student) getSession().get(Student.class, id);
	System.out.println(student.getCourses());
	  return student;
}

public void deleteStudent(int id) {
	Student student = (Student) getSession().get(Student.class, id);
	  getSession().delete(student);	
}

@SuppressWarnings("unchecked")
public Student findStudentByemail(String email, String Password) {
	Criteria criteria = getSession().createCriteria(Student.class);
	criteria.add(Restrictions.eq("email", email));
	criteria.add(Restrictions.eq("password",Password));
	List<Student> results = criteria.list();
	if(results.size()==0)
		return null;
	else
     return results.get(0);
}

public List<Course> Studentcourselist(int id) {
	Student student = findStudentById(id);
	return student.getCourses();
}

}