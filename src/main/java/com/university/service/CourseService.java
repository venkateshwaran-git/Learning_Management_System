package com.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.dao.CourseDAO;
import com.university.model.Announcement;
import com.university.model.Appointment;
import com.university.model.Attendance;
import com.university.model.Course;
import com.university.model.Grade;
import com.university.model.Student;
import com.university.model.exam;

@Service("courseService")
@Transactional
public class CourseService {

	CourseDAO courseDao;
	 
	 @Autowired
	 public void setCourseDao(CourseDAO courseDao) {
	  this.courseDao = courseDao;
	 }

	public List<Course> listAllCourses() {
		return courseDao.listAllCourses();
	}

	public void saveOrUpdate(Course course) {
		courseDao.saveOrUpdate(course);		
	}

	public Course findCourseById(int id) {
		return courseDao.findCourseById(id);
	}
	
	public List<Student> StudentsinCourse(int course_id) {
		return courseDao.StudentsinCourse(course_id);
	}	

	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
	}

	public boolean registerCourse(int course_id, int student_id) {
		return courseDao.registerCourse(course_id, student_id);		
	}
	
	public Grade findGradeById(int course_id, int student_id) {
		return courseDao.findGradeById(course_id, student_id);
	}
	
	public List<Grade> findGradeBycourse(int course_id) {
		return courseDao.findGradeBycourse(course_id); 
	}

	public void savegrade (Grade grade) {
		courseDao.savegrade(grade);		
	}
	
	public void AddAttendanceById(int course_id, int student_id, Boolean present) {
		courseDao.AddAttendanceById(course_id, student_id, present);
	}
	
	public List<Attendance> findAttendanceById(int course_id, int student_id) {
		return courseDao.findAttendanceById(course_id, student_id);
	}

    public void saveannouncement(Announcement ann, int course_id) {
    	courseDao.saveannouncement(ann, course_id);
    }

	public List<Announcement> findAnnouncementById(int course_id) {
		return courseDao.findAnnouncementById(course_id);
	}

    public void saveexam(exam ex, int course_id, int student_id) {
    	courseDao.saveexam(ex, course_id, student_id);
    }
    
	public List<exam> findexamById(int course_id, int student_id) {
		return courseDao.findexamById(course_id, student_id);
	}
	
	public List<exam> findexamBycourse(int course_id) {
		return courseDao.findexamBycourse(course_id);
	}

	public void saveAppointment(Appointment app, int course_id) {
		courseDao.saveAppointment(app, course_id);
	}

	public List<Appointment> findAppointmentBycourse(int course_id) {
		return courseDao.findAppointmentBycourse(course_id);
	}
	
	public List<Appointment> findmyAppointment(int course_id, int student_id) {
		return courseDao.findmyAppointment(course_id, student_id);
	}

	public void updateAppointment(Appointment app) {
		courseDao.updateAppointment(app);
	}
	
	 public Appointment findAppointmentById(int id) {
		 return courseDao.findAppointmentById(id);
	 }



}

 
 