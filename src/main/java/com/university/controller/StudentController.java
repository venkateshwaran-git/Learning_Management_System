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
import org.springframework.web.servlet.ModelAndView;

import com.university.model.Course;
import com.university.model.Student;
import com.university.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {

 @Autowired
 StudentService studentService;
 
 public static int S_admin_id;

 
 @RequestMapping(value="/list", method=RequestMethod.GET)
 public ModelAndView list(){
  ModelAndView model = new ModelAndView("student/list");
  List<Student> list = studentService.listAllStudents();
  model.addObject("list", list);
  return model;
 }
 
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView update(@PathVariable("id") int id){
  ModelAndView model = new ModelAndView("student/form");
  Student student = studentService.findStudentById(id);
  model.addObject("StudentForm", student);  
  return model;
 }
 
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView delete(@PathVariable("id") int id){
	 studentService.deleteStudent(id); 
  return new ModelAndView("redirect:/student/list");
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView add(){
  ModelAndView model = new ModelAndView("student/form");
  Student student = new Student();
  model.addObject("StudentForm", student);  
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView save(@Valid @ModelAttribute("StudentForm") Student student, BindingResult result){
	 if (result.hasErrors()) {
		 System.out.println("error");
         return new ModelAndView("student/form");
     }
	 studentService.saveOrUpdate(student);
  return new ModelAndView("redirect:/");
 }
 
 @RequestMapping(value="/login", method=RequestMethod.GET)
 public ModelAndView login(){
	 ModelAndView model = new ModelAndView("student/login");
	 Student student = new Student();
	  model.addObject("StudentForm", student);  
  return model;
 }
 
 @RequestMapping(value="/verify", method=RequestMethod.POST)
 public ModelAndView verify(@ModelAttribute("StudentForm") Student student){
	 if(studentService.verifyStudent(student.getEmail(), student.getPassword())) {
		 S_admin_id = studentService.findStudentByemail(student.getEmail(), student.getPassword()).getStudent_id();
		 return new ModelAndView("redirect:/student/home");}
	 else
		 return new ModelAndView("student/Retry"); 
 }
 
 @RequestMapping("/home")
 public ModelAndView home() {
	 ModelAndView model = new ModelAndView("student/home");
	  model.addObject("S_admin", studentService.findStudentById(S_admin_id));  
  return model;
 }
  
 @RequestMapping(value="/studentlist")
 public ModelAndView teacherlist(){
	 ModelAndView model = new ModelAndView("student/studentlist");
	 List<Course> collection = studentService.Studentcourselist(S_admin_id);
	 System.out.println(collection);
	  model.addObject("coursecollection", collection);  
 return model; }
 
}




