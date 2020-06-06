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
<title>BlackBoard - Student - course</title>
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
<h2>${course.name }</h2>
<br>
<br>

<div class="row">

<div class="col-sm-6">
<div class="card" >
<div class="card-body">   
<div> 
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
   <td>Teacher Handling</td>
   <td>${course.teacher1.firstname } ${course.teacher1.lastname }</td>  
  </tr>
  
   <tr>
   <td>Grade</td>
   <td>${ grade.grade }</td>  
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

<spring:url value="/course/viewappointment/${course.course_id }" var="openURL" />
 <h4><a href="${openURL }">To view your Appointments click here</a></h4> 
 
 <spring:url value="/course/openattendance/${course.course_id }" var="open2URL" />
 <h4><a href="${open2URL }">To view your Attendance click here</a></h4>
 
 <spring:url value="/course/openexam/${course.course_id }" var="open3URL" />
 <h4><a href="${open3URL }">To view your Exam Scores click here</a></h4>
 
</div>
</div>
</div>
</div>  

</div>
 
 <br>
 <hr>
 <br>
 <h4>Announcements</h4>
 <br>
 <table border="1">
  <tr>
   <td>Announcement ID</td>
   <td>Announcements</td>
  </tr>  
  <c:forEach items="${announce }" var="Announcement" >
   <tr>
    <td>${Announcement.announcement_id }</td>
    <td>${Announcement.announcement }</td>
   </tr>
  </c:forEach>
 </table>
 
 
 
 </div>
</body>
</html>
