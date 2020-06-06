<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    
    
<!doctype html>
<html lang="en">

<head>
<style type="text/css">
#error {
	color: red;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Teacher - Announcement</title>
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
<h2><a href="${CURL }">${course.name }</a> Announcement</h2>
<br>

 <spring:url value="/course/saveannouncement/${course.course_id}" var="saveURL" />
 <form:form action="${saveURL }" method="POST" modelAttribute="announce" name = "myForm" onsubmit = "return(validate());">
  
   <label for="announcement">Announcement Content:</label><br>
   <form:textarea path="announcement" rows="3" cols="100" type="text" id = "Name"/>
   <span id="error"></span>
   <br>
   <br>
   <input type="submit">
 </form:form>
 </div>
 <script type = "text/javascript">
   
      function validate() {
      
         if( document.getElementById('Name').value == "" ) {
            document.getElementById('error').innerHTML = "Please fill in the Announcement";
            return false;
         }
     return true;
      }
</script>
</body>
</html>
