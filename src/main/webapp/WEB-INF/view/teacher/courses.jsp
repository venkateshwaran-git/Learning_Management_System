<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    
    
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Teacher - My Courses</title>
</head>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://www.pngitem.com/pimgs/m/4-43262_school-png-photo-transparent-school-logo-png-png.png" width="50" height="50" class="d-inline-block align-top" alt="">
    <span  class="navbar-brand ">BlackBoard</span> 
  </a>
  <a class="nav-item nav-link nav-right font-weight-bold" href="/Skl_Administration">Sign-Out</a>
</nav>
<nav class="navbar navbar-light bg-dark">   
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/teacher/home">Home</a>
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/course/add">Add New Course</a>
      <a class="nav-item nav-link active text-white mx-auto font-weight-bold" href="/Skl_Administration/teacher/teacherlist">My Courses</a>  
</nav>

<body>
<div class="container">
<br>
<br>

<div class="row">

<div class="col-sm-6">
<div class="card" >
<div class="card-body">   
<div>
 <h2>${course.name }</h2>
 
 <table  border="1">
  <tr>
   <td>course_id</td>
   <td>${course.course_id }</td>
  </tr>  
  
  <tr>
   <td>Classroom</td>
   <td>${course.classroom }</td>  
  </tr>
  
  <tr>
   <td>Timings</td>
   <td>${course.timings }</td>  
  </tr>
  
  <tr>
   <td>Credits</td>
   <td>${course.credits }</td>  
  </tr>
  
   <tr>
   <td>Class Capacity Remaining</td>
   <td>${course.capacity }</td>  
  </tr>
  
  <tr>
   <td>Teacher Handling</td>
   <td>${course.teacher1.firstname } ${course.teacher1.lastname }</td>  
  </tr>  
 </table>
</div>
</div>
</div>
</div>

<div class="col-sm-6">
<div class="card" >
<div class="card-body">
<div>
     <spring:url value="/course/publishgrades/${course.course_id }" var="open1URL" />
     <h4><a href="${open1URL }">To publish grades click here</a></h4>
     <br>
     
     <spring:url value="/course/recordattendance/${course.course_id }" var="open2URL" />
     <h4><a href="${open2URL }">To Record Attendance click here</a></h4>
     <br>
 
 	 <spring:url value="/course/addannouncement/${course.course_id }" var="open3URL" />
     <h4><a href="${open3URL }">To make an Announcement click here</a></h4>
     <br>
     
     <spring:url value="/course/addexam/${course.course_id }" var="open4URL" />
     <h4><a href="${open4URL }">To add an Exam click here</a></h4>
     <br>
     
     <spring:url value="/course/addappointment/${course.course_id }" var="open5URL" />
     <h4><a href="${open5URL }">To publish your Appointment click here</a></h4>    
</div>
</div>
</div>
</div>
 
</div>
</div>
</body>
</html>
