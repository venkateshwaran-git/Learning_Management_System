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
<h2><a href="${CURL }">${course.name }</a> Exam</h2>
<br>

 <spring:url value="/course/addexam2/${course.course_id}" var="saveURL" />
 <form:form action="${saveURL }" method="GET" modelAttribute="ex" name = "myForm" onsubmit = "return(validate());">
  
  <table>
   <tr>
    <td><label for="name">Exam Name:&nbsp;</label></td>
  	<td><form:input path="name" id = "Name"/></td>
  	<td><span id="nameerror"></span></td> 	
   </tr>
   <tr>
    <td><label for="totalmark">Total Mark:</label></td>
  	<td><form:input path="totalmark" type="number" id = "mark"/></td>
  	<td><span id="markerror"></span></td>
   </tr>
  </table>
 <br>
  <input type="submit"> 
 </form:form>
 </div>
 <script type = "text/javascript"> 
      function validate() {
      
         if( document.getElementById('Name').value == "" ) {
            document.getElementById('nameerror').innerHTML = "Please fill in the Exam name";
            return false;
         }
         else document.getElementById('nameerror').innerHTML = "";
         
         if( document.getElementById('mark').value == 0 ) {
             document.getElementById('markerror').innerHTML = "Please fill in the Exam total mark";
             return false;
          }
         else document.getElementById('markerror').innerHTML = "";
         
     return true;
      }
</script>
</body>
</html>
