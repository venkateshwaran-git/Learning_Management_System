<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">

<head>
<style type="text/css">
.error {
	color: red;
}
</style>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Register</title>
</head>
</head>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://www.pngitem.com/pimgs/m/4-43262_school-png-photo-transparent-school-logo-png-png.png" width="50" height="50" class="d-inline-block align-top" alt="">
    <span  class="navbar-brand ">BlackBoard</span> 
  </a>
</nav>

<body>
<div class="container">
<br>
<h2>Fill in the Teacher details</h2>
<br>

 <spring:url value="/teacher/save" var="saveURL" />
 <form:form action="${saveURL }" method="POST" modelAttribute="TeacherForm">
  <table>
   <tr>
    <td>Firstname</td>
    <td><form:input path="firstname"/></td>
    <td><form:errors path="firstname" cssClass="error"/></td>
   </tr>
   <tr>
    <td>Lastname</td>
    <td><form:input path="lastname"/></td>
    <td><form:errors path="lastname" cssClass="error"/></td>
   </tr>  
   <tr>
    <td>Email</td>
    <td><form:input path="email"/></td>
    <td><form:errors path="email" cssClass="error"/></td>
   </tr>
   <tr>
    <td>Password</td>
    <td><form:input path="password" type="password"/></td>
    <td><form:errors path="password" cssClass="error"/></td>
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