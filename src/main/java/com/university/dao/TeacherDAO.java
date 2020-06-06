package com.university.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.model.Course;
import com.university.model.Teacher;

@Repository("teacherDao")
public class TeacherDAO{

	@Autowired
	 private SessionFactory sessionFactory;

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }
	 
	@SuppressWarnings("unchecked")
	public List<Teacher> listAllTeachers() {
		Criteria criteria = getSession().createCriteria(Teacher.class);
		  return (List<Teacher>) criteria.list();
	}

	public void saveOrUpdate(Teacher teacher) {
		getSession().saveOrUpdate(teacher);		
	}

	public Teacher findTeacherById(int id) {
		Teacher teacher = (Teacher) getSession().get(Teacher.class, id);
		  return teacher;
	}

	public void deleteTeacher(int id) {
		Teacher teacher = (Teacher) getSession().get(Teacher.class, id);
		  getSession().delete(teacher);			
	}

	@SuppressWarnings("unchecked")
	public Teacher findTeacherByemail(String email, String Password) {
		Criteria criteria = getSession().createCriteria(Teacher.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password",Password));
		List<Teacher> results = criteria.list();
		if(results.size()==0)
			return null;
		else
         return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> Teachercourselist(int id) {
		Criteria cr =getSession().createCriteria(Course.class);
		cr.createAlias("teacher1", "teacher");
		cr.add(Restrictions.eq("teacher.teacher_id",id));
		List<Course> results = cr.list();
		System.out.println(results);
		return results;
	}
}
