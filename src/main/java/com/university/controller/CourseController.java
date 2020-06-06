package com.university.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.university.model.Announcement;
import com.university.model.Appointment;
import com.university.model.Attendance;
import com.university.model.Course;
import com.university.model.Grade;
import com.university.model.Student;
import com.university.model.Teacher;
import com.university.model.exam;
import com.university.service.CourseService;
import com.university.service.StudentService;

@Controller
@RequestMapping(value="/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	 StudentService studentService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addcourse(){
	  ModelAndView model = new ModelAndView("teacher/courseform");
	  Course course = new Course();
	  model.addObject("CourseForm", course);  
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView savecourse(@Valid @ModelAttribute("CourseForm") Course course1, BindingResult result){
		 if (result.hasErrors()) {
			 System.out.println("error");
	         return new ModelAndView("teacher/courseform");
	     }
		 Teacher t = TeacherController.T_admin;	 
		 course1.setTeacher1(t);
		 courseService.saveOrUpdate(course1);
	  return new ModelAndView("redirect:/teacher/home");
	 }
	 
	 @RequestMapping(value="/register", method=RequestMethod.GET)
	 public ModelAndView register(){
	  ModelAndView model = new ModelAndView("student/register");
	  List<Course> list = courseService.listAllCourses();
	  model.addObject("list", list);
	  return model;
	 }
	 
	 @RequestMapping(value="/registercourse/{id}", method=RequestMethod.GET)
	 public ModelAndView registercourse(@PathVariable("id") int course_id){
	  if(courseService.registerCourse(course_id, StudentController.S_admin_id))
		  return new ModelAndView("redirect:/student/home");
	  else
		  return new ModelAndView("redirect:/student//studentlist");
		  
	 }
	 
	 @RequestMapping(value="/opencourse/{id}", method=RequestMethod.GET)
	 public ModelAndView opencourse(@PathVariable("id") int course_id){
	  Course course = courseService.findCourseById(course_id);
	  Grade grade = courseService.findGradeById(course_id, StudentController.S_admin_id);
	  List<Announcement> announce = courseService.findAnnouncementById(course_id);
	  
	  ModelAndView model = new ModelAndView("student/courses");
	  model.addObject("grade", grade);
	  model.addObject("course", course);
	  model.addObject("announce", announce);

	  return model;
	 }
	 
	 @RequestMapping(value="/coursestudents/{id}", method=RequestMethod.GET)
	 public ModelAndView coursestudents(@PathVariable("id") int course_id){
	  if(courseService.registerCourse(course_id, StudentController.S_admin_id))
		  return new ModelAndView("redirect:/student/home");
	  else
		  return new ModelAndView("redirect:/student/studentlist");
		  
	 }
	 
	 @RequestMapping(value="/publishgrades/{id}", method=RequestMethod.GET)
	 public ModelAndView publishgrades(@PathVariable("id") int course_id){
		  System.out.println(course_id);
		 List<Grade> list = courseService.findGradeBycourse(course_id);
		 ModelAndView model = new ModelAndView("teacher/coursegrades");
		  model.addObject("list", list);
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  System.out.println(list);
		  return model;
	 }
	 
	 @RequestMapping(value="/updategrades/{id}", method=RequestMethod.POST)
	 public ModelAndView updategrades(@PathVariable("id") int course_id, HttpServletRequest request){
		 List<Grade> list = courseService.findGradeBycourse(course_id);
		 System.out.println(course_id);
		 for(Grade grade: list) {
			 grade.setGrade((String)request.getParameter(String.valueOf(grade.getGrade_id())));
			 courseService.savegrade(grade);
		 }
		 ModelAndView model = new ModelAndView("teacher/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/recordattendance/{id}", method=RequestMethod.GET)
	 public ModelAndView recordattendance(@PathVariable("id") int course_id){
		 List<Grade> list = courseService.findGradeBycourse(course_id);
		 ModelAndView model = new ModelAndView("teacher/attendance");
		  model.addObject("list", list);
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  System.out.println(list);
		  return model;
	 }
	 
	 @RequestMapping(value="/updateattendance/{id}", method=RequestMethod.POST)
	 public ModelAndView updateattendance(@PathVariable("id") int course_id, HttpServletRequest request){
		 List<Grade> list = courseService.findGradeBycourse(course_id);
		 System.out.println(course_id);
		 for(Grade grade: list) {
			 int student_id = grade.getStudentG().getStudent_id();
			 String attend = request.getParameter(String.valueOf(grade.getGrade_id()));
			 Boolean present;
			 if(attend.equals("1"))
				 present = true;
			 else
				 present = false;
			 System.out.println(attend);
			 courseService.AddAttendanceById(course_id, student_id, present);
		 }
		 ModelAndView model = new ModelAndView("teacher/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/addannouncement/{id}", method=RequestMethod.GET)
	 public ModelAndView addannouncement(@PathVariable("id") int course_id){
		 ModelAndView model = new ModelAndView("teacher/newannouncement");
		 Announcement ann = new Announcement();
		 ann.setCourse_An(courseService.findCourseById(course_id));
		  model.addObject("announce", ann);
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  return model;
	 }
	 
	 @RequestMapping(value="/saveannouncement/{id}", method=RequestMethod.POST)
	 public ModelAndView saveannouncement(@ModelAttribute("announce") Announcement announcement, @PathVariable("id") int course_id){
		
		 System.out.println(announcement.getAnnouncement());

		 courseService.saveannouncement(announcement, course_id);
		 return new ModelAndView("redirect:/teacher/home");
	 }
	 
	 @RequestMapping(value="/addexam/{id}", method=RequestMethod.GET)
	 public ModelAndView addexam(@PathVariable("id") int course_id){
		 ModelAndView model = new ModelAndView("teacher/newexam");
		 exam ex = new exam();
		 ex.setCourse_E(courseService.findCourseById(course_id));

		  model.addObject("ex", ex);  
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  return model;
	 }
	 
	 @RequestMapping(value="/addexam2/{id}", method=RequestMethod.GET)
	 public ModelAndView addexam2(@ModelAttribute("ex") exam exam1, @PathVariable("id") int course_id){
		 ModelAndView model = new ModelAndView("teacher/newexam2");
		 System.out.println(exam1.getName());
		 System.out.println(exam1.getTotalmark());
		 List<Student> list = courseService.StudentsinCourse(course_id);

		  exam ex = new exam();
		  model.addObject("ex", ex);  
		  model.addObject("exam1", exam1);
		  model.addObject("list", list);
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  return model;
	 }
	 
	 @RequestMapping(value="/saveexam/{id}", method=RequestMethod.POST)
	 public ModelAndView saveexam(@ModelAttribute("ex") exam ex, @PathVariable("id") int course_id, HttpServletRequest request){
		
		 List<Student> list = courseService.StudentsinCourse(course_id);
		 System.out.println(course_id);
		 for(Student student: list) {
			 int mark = Integer.parseInt(request.getParameter(String.valueOf(student.getStudent_id())));
			 System.out.println(mark);
			 exam exam1 = new exam();
			 exam1.setMark(mark);
			 exam1.setName(ex.getName());
			 exam1.setTotalmark(ex.getTotalmark());
			 courseService.saveexam(exam1, course_id, student.getStudent_id());
		 }
		 System.out.println(ex.getName());
		 System.out.println(ex.getTotalmark());
		 ModelAndView model = new ModelAndView("redirect:/teacher/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/addappointment/{id}", method=RequestMethod.GET)
	 public ModelAndView addappointment(@PathVariable("id") int course_id){
		 ModelAndView model = new ModelAndView("teacher/newappointment");
		 Appointment app = new Appointment();
		 app.setCourse_App(courseService.findCourseById(course_id));

		  model.addObject("app", app);
		  Course course = courseService.findCourseById(course_id);
		  model.addObject("course", course);
		  return model;
	 }
	 
	 @RequestMapping(value="/saveappointment/{id}", method=RequestMethod.POST)
	 public ModelAndView saveappointment(@ModelAttribute("app") Appointment app, @PathVariable("id") int course_id){
		 
		app.setAppointment_status("Available");
		courseService.saveAppointment(app, course_id);
		 ModelAndView model = new ModelAndView("teacher/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/viewappointment/{id}", method=RequestMethod.GET)
	 public ModelAndView viewappointment(@PathVariable("id") int course_id){
	  
	  Course course = courseService.findCourseById(course_id);
	  List<Appointment> app_available = courseService.findAppointmentBycourse(course_id);
	  List<Appointment> My_app = courseService.findmyAppointment(course_id, StudentController.S_admin_id);
	  
	  ModelAndView model = new ModelAndView("student/appointments");
	  model.addObject("app_available", app_available);
	  model.addObject("My_app", My_app);
	  model.addObject("course", course);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/bookappointment/{id}", method=RequestMethod.GET)
	 public ModelAndView bookappointment(@PathVariable("id") int appointment_id){
		 
		 Appointment app = courseService.findAppointmentById(appointment_id);
		 app.setAppointment_status("Booked");
		 app.setStudent_App(studentService.findStudentById(StudentController.S_admin_id));
		 courseService.updateAppointment(app);
		 
		 ModelAndView model = new ModelAndView("redirect:/student/home");
		  return model;
	 }
	 
	 @RequestMapping(value="/openattendance/{id}", method=RequestMethod.GET)
	 public ModelAndView openattendance(@PathVariable("id") int course_id){
	  List<Attendance> attend = courseService.findAttendanceById(course_id, StudentController.S_admin_id);
	  Course course = courseService.findCourseById(course_id);

	  ModelAndView model = new ModelAndView("student/attendance_record"); 
	  model.addObject("attend", attend);
	  model.addObject("course", course);

	  return model;
	 }
	 
	 @RequestMapping(value="/openexam/{id}", method=RequestMethod.GET)
	 public ModelAndView openexam(@PathVariable("id") int course_id){
		 List<exam> ex = courseService.findexamById(course_id, StudentController.S_admin_id);
		  Course course = courseService.findCourseById(course_id);
		  
		  ModelAndView model = new ModelAndView("student/exam_record");
		  model.addObject("ex", ex);
		  model.addObject("course", course);

		  return model;
	 }
	 
}
