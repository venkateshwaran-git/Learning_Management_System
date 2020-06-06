package com.university.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.university.model.Course;
import com.university.model.Teacher;
import com.university.service.CourseService;
import com.university.service.TeacherService;
@SessionAttributes(value = "T_admin")
@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

@Autowired
TeacherService teacherService;
@Autowired
CourseService courseService;

public static Teacher T_admin; 

 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list(){
  ModelAndView model = new ModelAndView("student/list");
  List<Teacher> list = teacherService.listAllTeachers();
  model.addObject("list", list);
  return model;
 }
 
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView update(@PathVariable("id") int id){
  ModelAndView model = new ModelAndView("student/form");
  Teacher teacher = teacherService.findTeacherById(id);
  model.addObject("TeacherForm", teacher);  
  return model;
 }
 
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") int id){
	 teacherService.deleteTeacher(id); 
  return new ModelAndView("redirect:/student/list");
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView add(){
  ModelAndView model = new ModelAndView("teacher/form");
  Teacher teacher = new Teacher();
  model.addObject("TeacherForm", teacher);  
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView save(@Valid @ModelAttribute("TeacherForm") Teacher teacher, BindingResult result){
	 if (result.hasErrors()) {
		 System.out.println("error");
         return new ModelAndView("teacher/form");
     }
	 teacherService.saveOrUpdate(teacher);
  return new ModelAndView("redirect:/welcome");
 }
 
 @RequestMapping(value="/login", method=RequestMethod.GET)
 public ModelAndView login(){
	 ModelAndView model = new ModelAndView("teacher/login");
	 Teacher teacher = new Teacher();
	  model.addObject("TeacherForm", teacher);  
  return model;
 }
 
 @RequestMapping(value="/verify", method=RequestMethod.POST)
 public ModelAndView verify(@ModelAttribute("TeacherForm") Teacher teacher){
	 if(teacherService.verifyTeacher(teacher.getEmail(), teacher.getPassword())) {
		 T_admin = teacherService.findTeacherByemail(teacher.getEmail(), teacher.getPassword());
		 teacherService.findTeacherByemail(teacher.getEmail(), teacher.getPassword()).toString();
		 return new ModelAndView("redirect:/teacher/home");}
	 else
		 return new ModelAndView("teacher/Retry"); 
 }
 
 @RequestMapping("/home")
 public ModelAndView home() {
	 ModelAndView model = new ModelAndView("teacher/home");
	  model.addObject("T_admin", T_admin);  
  return model;
 }
  
 @RequestMapping(value="/teacherlist")
 public ModelAndView teacherlist(){
	 ModelAndView model = new ModelAndView("teacher/teacher-courselist");
	 List<Course> collection = teacherService.Teachercourselist(T_admin.getTeacher_id());
	  model.addObject("coursecollection", collection);  
 return model; }
 
 @RequestMapping(value="/opencourse/{id}", method=RequestMethod.GET)
 public ModelAndView opencourse(@PathVariable("id") int course_id){
  Course course = courseService.findCourseById(course_id);
  ModelAndView model = new ModelAndView("teacher/courses");
  model.addObject("course", course);
  return model;
 }
 
}




