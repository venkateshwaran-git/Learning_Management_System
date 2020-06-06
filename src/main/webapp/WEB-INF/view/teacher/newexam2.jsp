<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    
    
<!doctype html>
<html lang="en">

<head>
<style type="text/css">
#nameerror #markerror {
	color: red;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Teacher - exam</title>
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
<body id="main">
<div class="container">
<br>
<spring:url value="/teacher/opencourse/${course.course_id }" var="CURL" />
<h2><a href="${CURL }">${course.name }</a> Exam </h2>
<br>
<table>
  <tr>
   <td>Exam name:</td>
   <td>${exam1.name}</td>
  </tr> 
   <tr>
    <td>Total mark:</td>
    <td>${exam1.totalmark}</td>
   </tr>
 </table>
 <br>
 <hr>
 <spring:url value="/course/saveexam/${course.course_id}" var="saveURL" />
 <form:form action="${saveURL }" method="POST" modelAttribute="ex" >
  
  <form:hidden path="name" value="${exam1.name}"/>
  <form:hidden path="totalmark" value="${exam1.totalmark}"/>
  <form:input path="mark" type="hidden" value="0"/>
  
  
   <h5>Enter the marks scored by students in the exam individually</h5>
   <br>
  <table border="1">
  <tr>
   <td>ID</td>
   <td>Student Name</td>
   <td>Mark scored</td>
  </tr> 
  <c:forEach items="${list }" var="student" >
   <tr>
    <td>${student.student_id }</td>
    <td>${student.firstname } ${student.lastname }</td>
    <td><input name="${student.student_id }" type="number" min="0" max="${exam1.totalmark}" /></td>  
   </tr>
  </c:forEach>
 </table>
 <br>
  <input type="submit"> 
 </form:form>
 </div>
</body>
</html>
