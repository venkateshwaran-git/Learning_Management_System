package com.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.university.dao.TeacherDAO;
import com.university.model.Course;
import com.university.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherService{

	TeacherDAO teacherDao;
	 
	 @Autowired
	 public void setTeacherDao(TeacherDAO teacherDao) {
	  this.teacherDao = teacherDao;
	 }
	 
	public List<Teacher> listAllTeachers() {
		  return teacherDao.listAllTeachers();
	}

	public void saveOrUpdate(Teacher teacher) {
		teacherDao.saveOrUpdate(teacher);			
	}

	public Teacher findTeacherById(int id) {
		  return teacherDao.findTeacherById(id);
	}

	public void deleteTeacher(int id) {
		teacherDao.deleteTeacher(id);			
	}

	public boolean verifyTeacher(String email, String password) {
		Teacher teacher1 = teacherDao.findTeacherByemail(email, password);
		if(teacher1!=null)
		return true;
		else 
		return false;
	}
	
	//@ModelAttribute("teacheradmin")
	public Teacher findTeacherByemail(String email, String password) {
		return teacherDao.findTeacherByemail(email, password);			
	}

	public List<Course> Teachercourselist(int id) {
		return teacherDao.Teachercourselist(id);			
	}


}
