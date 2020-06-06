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
<title>BlackBoard - Teacher - Update Attendance</title>
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
<spring:url value="/teacher/opencourse/${course.course_id }" var="CURL" />
<h2><a href="${CURL }">${course.name }</a> Attendance</h2>
<br>
  
   <spring:url value="/course/updateattendance/${course.course_id }" var="updateURL" />
   <form action="${updateURL }" method="POST" >
 
 <table border="1">
  <tr>
   <td>ID</td>
   <td>First name</td>
   <td>Last name</td>
   <td>Gender</td>
   <td>Address</td>
   <td colspan="2">Present?</td>
  </tr>  
  <c:forEach items="${list }" var="grade" >
   <tr>
    <td>${grade.studentG.student_id }</td>
    <td>${grade.studentG.firstname }</td>
    <td>${grade.studentG.lastname }</td>
    <td>${grade.studentG.gender }</td>
    <td>${grade.studentG.address }</td>
   <td> 
     <select name="${grade.grade_id}" >  
        <option value=1 label="True"/>  
        <option value=0 label="False"/>  
      </select></td>   
   </tr>
  </c:forEach>
 </table>
 <br>
 <button type="submit">Update results</button>
 </form>
 
 </div>
</body>
</html>
