package com.university.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.university.model.Announcement;
import com.university.model.Appointment;
import com.university.model.Attendance;
import com.university.model.Course;
import com.university.model.Grade;
import com.university.model.Student;
import com.university.model.exam;

@Component("courseDao")
@Transactional
public class CourseDAO{

	@Autowired
	 private SessionFactory sessionFactory;

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }

	@SuppressWarnings("unchecked")
	public List<Course> listAllCourses() {
		Criteria criteria = getSession().createCriteria(Course.class);
		  return (List<Course>) criteria.list();
	}
	
	public List<Student> StudentsinCourse(int course_id) {
		List<Grade> list = findGradeBycourse(course_id);
		List<Student> studentz = new ArrayList<Student>(list.size());
		for(Grade g : list) {
			studentz.add(g.getStudentG());
		}
		return studentz;
	}

	public void saveOrUpdate(Course course) {
		getSession().saveOrUpdate(course);
	}

	public Course findCourseById(int id) {
		Course course = (Course) getSession().get(Course.class, id);
		return course;
	}

	public void deleteCourse(int id) {
		Course course = (Course) getSession().get(Course.class, id);
		  getSession().delete(course);			
	}
	
	public boolean registerCourse(int course_id, int student_id) {
		Course course = (Course) getSession().get(Course.class, course_id ); 
		Student student = (Student) getSession().get(Student.class, student_id);
		
		if((findGradeById(course.getCourse_id(), student.getStudent_id())==null) && (course.getCapacity()>0)) {
			course.getStudents().add(student);  
			course.setCapacity(course.getCapacity()-1);
			getSession().saveOrUpdate(course);
			
			student.getCourses().add(course);  
			getSession().saveOrUpdate(student);			
			
		Grade grade = new Grade(course, student);
		getSession().saveOrUpdate(grade);
		
		return true;
		}
		else {
			return false;
		}
	}	 
	
	@SuppressWarnings("unchecked")
	public Grade findGradeById(int course_id, int student_id) {
		Criteria criteria = getSession().createCriteria(Grade.class);
		criteria.add(Restrictions.eq("courseG", findCourseById(course_id)));
		criteria.add(Restrictions.eq("studentG", (Student) getSession().get(Student.class, student_id)));
		List<Grade> results = criteria.list();
		if(results.size()==0)
			return null;
		else
	     return results.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Grade> findGradeBycourse(int course_id) {
		Criteria criteria = getSession().createCriteria(Grade.class);
		criteria.add(Restrictions.eq("courseG", findCourseById(course_id)));
		List<Grade> results = criteria.list();
	     return results;
	}
	
	public void savegrade (Grade grade) {
		getSession().saveOrUpdate(grade);
	}
	
	@SuppressWarnings("unchecked")
	public List<Attendance> findAttendanceById(int course_id, int student_id) {
		Criteria criteria = getSession().createCriteria(Attendance.class);
		criteria.add(Restrictions.eq("course_A", findCourseById(course_id)));
		criteria.add(Restrictions.eq("student_A", (Student) getSession().get(Student.class, student_id)));
		List<Attendance> results = criteria.list();
		
	     return results;
	}
	
	public void AddAttendanceById(int course_id, int student_id, Boolean present) {
		
		Course course = (Course) getSession().get(Course.class, course_id ); 
		Student student = (Student) getSession().get(Student.class, student_id);
		Date today = new Date();
		
		Attendance Att = new Attendance(present, today, student, course);	
		getSession().saveOrUpdate(Att);		
	}
	    
    public void saveannouncement(Announcement ann, int course_id) {
		Course course = (Course) getSession().get(Course.class, course_id ); 
		ann.setCourse_An(course);
    	System.out.println(ann.getCourse_An());
		getSession().saveOrUpdate(ann);
	}
    
    @SuppressWarnings("unchecked")
	public List<Announcement> findAnnouncementById(int course_id) {
		Criteria criteria = getSession().createCriteria(Announcement.class);
		criteria.add(Restrictions.eq("course_An", findCourseById(course_id)));
		List<Announcement> results = criteria.list();
		
	     return results;
	}
    
    public void saveexam(exam ex, int course_id, int student_id) {
		Course course = (Course) getSession().get(Course.class, course_id ); 
		Student student = (Student) getSession().get(Student.class, student_id);
		ex.setCourse_E(course);
		ex.setStudent_E(student);
		getSession().saveOrUpdate(ex);
	}
	
    @SuppressWarnings("unchecked")
	public List<exam> findexamById(int course_id, int student_id) {
		Criteria criteria = getSession().createCriteria(exam.class);
		criteria.add(Restrictions.eq("student_E", (Student) getSession().get(Student.class, student_id)));
		criteria.add(Restrictions.eq("course_E", findCourseById(course_id)));
		List<exam> results = criteria.list();
		
	     return results;
	}
	
	 @SuppressWarnings("unchecked")
	 public List<exam> findexamBycourse(int course_id) {
			Criteria criteria = getSession().createCriteria(exam.class);
			criteria.add(Restrictions.eq("course_E", findCourseById(course_id)));
			List<exam> results = criteria.list();
			
		     return results;
		}
	 
	 public Appointment findAppointmentById(int id) {
		 Appointment app = (Appointment) getSession().get(Appointment.class, id);
			return app;
		}
	 
		public void saveAppointment(Appointment app, int course_id) {
			Course course = (Course) getSession().get(Course.class, course_id ); 
			app.setCourse_App(course);
			getSession().saveOrUpdate(app);

			app.setLink("/course/bookappointment/"+Integer.toString(app.getAppointment_id()));
			getSession().saveOrUpdate(app);
		}
		
		public void updateAppointment(Appointment app) {
			app.setLink("#");
			getSession().saveOrUpdate(app);
		}
		
		@SuppressWarnings("unchecked")
		public List<Appointment> findAppointmentBycourse(int course_id) {
			Criteria criteria = getSession().createCriteria(Appointment.class);
			criteria.add(Restrictions.eq("course_App", findCourseById(course_id)));
			List<Appointment> results = criteria.list();
			
		     return results;
		}
		
		@SuppressWarnings("unchecked")
		public List<Appointment> findmyAppointment(int course_id, int student_id) {
			Criteria criteria = getSession().createCriteria(Appointment.class);
			criteria.add(Restrictions.eq("course_App", findCourseById(course_id)));
			criteria.add(Restrictions.eq("student_App", (Student) getSession().get(Student.class, student_id)));
			List<Appointment> results = criteria.list();
			
		     return results;
		}
}
