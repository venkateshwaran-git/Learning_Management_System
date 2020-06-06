<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<style type="text/css">
.error {
	color: red;
}
</style>
<title>Course Form</title>
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
      <a class="nav-item nav-link active text-white mx-auto font-weight-bold" href="/Skl_Administration/course/add">Add New Course</a>
      <a class="nav-item nav-link mx-auto font-weight-bold" href="/Skl_Administration/teacher/teacherlist">My Courses</a>  
</nav>



<body>
<div class="container justify-content-center ">
<br>
<h2>Fill in the Course details</h2>
<br>
 <spring:url value="/course/save" var="saveURL" />
 <form:form action="${saveURL }" method="POST" modelAttribute="CourseForm">
  <table>
   <tr>
    <td>Course name</td>
    <td><form:input path="name"/></td>
    <td><form:errors path="name" cssClass="error"/></td>
   </tr>
   <tr>
    <td>classroom</td>
    <td><form:input path="classroom"/></td>
    <td><form:errors path="classroom" cssClass="error"/></td>
   </tr>
   <tr>
    <td>capacity</td>
    <td><form:input path="capacity" type="number"/></td>
    <td><form:errors path="capacity" cssClass="error"/></td>
   </tr> 
   <tr>
    <td>credits</td>
    <td><form:input path="credits" type="number"/></td>
    <td><form:errors path="credits" cssClass="error"/></td>
   </tr>  
   <tr>
    <td>Timings</td>
    <td><form:textarea path="timings" rows="4" /></td>
    <td><form:errors path="timings" cssClass="error"/></td>
   </tr>
   <tr>
    <td></td>
    <td><button type="submit">Save</button></td>
   </tr>
  </table>
 </form:form>
 </div>
</body>
</html>