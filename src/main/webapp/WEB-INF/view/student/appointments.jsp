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
<title>BlackBoard - Student - Appointments</title>
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
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/course/register">Register New Course</a>
      <a class="nav-item nav-link active text-white mx-auto font-weight-bold" href="/Skl_Administration/student/studentlist">My Courses</a>  
</nav>

<body>
<div class="container justify-content-center ">
<br>
<spring:url value="/course/opencourse/${course.course_id }" var="openURL" />
<h2><a href="${openURL }">${course.name }</a> Appointments</h2>
<br>
<br>
<h2>My Booked Appointments</h2>
<br> 
 <table  border="1">
  <tr>
   <td>appointment_id</td>
   <td>appointment_date</td>
   <td>begin_at</td>
   <td>end_at</td>
   <td>appointment_status</td>
  </tr>  
  <c:forEach items="${My_app }" var="appointment" >
   <tr>
    <td>${appointment.appointment_id }</td>
    <td>${appointment.appointment_date }</td>
    <td>${appointment.begin_at }</td>
    <td>${appointment.end_at }</td>
    <td>${appointment.appointment_status }</td>
   </tr>
  </c:forEach>
 </table>
 <br>
 <hr>
 <h2>All Appointments</h2>
 <br>
 <table  border="1">
  <tr>
   <td>appointment_id</td>
   <td>appointment_date</td>
   <td>begin_at</td>
   <td>end_at</td>
   <td>appointment_status</td>
   <td>Action</td>
  </tr>  
  <c:forEach items="${app_available }" var="appointment" >
   <tr>
    <td>${appointment.appointment_id }</td>
    <td>${appointment.appointment_date }</td>
    <td>${appointment.begin_at }</td>
    <td>${appointment.end_at }</td>
    <td>${appointment.appointment_status }</td>
    <td>
     <spring:url value="${appointment.link }" var="openURL" />
     <a href="${openURL }">Book</a>
    </td>
   </tr>
  </c:forEach>
 </table>
 </div>
</body>
</html>
