<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>Course Registration</title>
</head>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://www.pngitem.com/pimgs/m/4-43262_school-png-photo-transparent-school-logo-png-png.png" width="50" height="50" class="d-inline-block align-top" alt="">
    <span  class="navbar-brand ">BlackBoard</span> 
  </a>
  <a class="nav-item nav-link nav-right font-weight-bold" href="/Skl_Administration">Sign-Out</a>
</nav>
<nav class="navbar navbar-light bg-dark">   
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/student/home">Home</a>
      <a class="nav-item nav-link mx-auto active text-white font-weight-bold" href="/Skl_Administration/course/register">Register New Course</a>
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/student/studentlist">My Courses</a>  
</nav>

<body>
<div class="container justify-content-center ">
<br>
<h2>List of Courses Offered</h2>
<br>  
 <table border="1">
  <tr>
   <td>course_id</td>
   <td>Course_Name</td>
   <td>Classroom</td>
   <td>Timings</td>
   <td>Credits</td>
   <td>Teacher Handling</td>
   <td>Seats available</td>
   <td colspan="2">Action</td>
  </tr>  
  <c:forEach items="${list }" var="course" >
   <tr>
    <td>${course.course_id }</td>
    <td>${course.name }</td>
    <td>${course.classroom }</td>
    <td>${course.timings }</td>
    <td>${course.credits }</td>
    <td>${course.teacher1.firstname } ${course.teacher1.lastname }</td>
    <td>${course.capacity }</td>
    <td>
     <spring:url value="/course/registercourse/${course.course_id }" var="registerURL" />
     <a href="${registerURL }">Register</a>
    </td>
   </tr>
  </c:forEach>
 </table>
 </div>
</body>
</html>