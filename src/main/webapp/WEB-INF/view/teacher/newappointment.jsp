<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
    
    
<!doctype html>
<html lang="en">

<head>
<style type="text/css">
#dateerror #beginerror #enderror {
	color: red;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Teacher - Appointment</title>
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
<h2><a href="${CURL }">${course.name }</a> Appointment</h2>
<br>

 <spring:url value="/course/saveappointment/${course.course_id}" var="saveURL" />
 <form:form action="${saveURL }" method="POST" modelAttribute="app" name = "myForm" onsubmit = "return(validate());">
  <table>
   <tr>
    <td><label for="appointment_date">Date of Appointment:&nbsp;</label></td>
  	<td><form:input path="appointment_date" placeholder="yyyy-mm-dd" id = "date"/></td>
  	<td><span id="dateerror"></span></td> 
   </tr>
   <tr>
    <td><label for="begin_at">Session Start Time:</label></td>
  	<td><form:input path="begin_at" placeholder="hh:mm" id = "begin"/></td>
  	<td><span id="beginerror"></span></td> 
   </tr>
   <tr>
    <td><label for="end_at">Session End Time:</label></td>
  	<td><form:input path="end_at" placeholder="hh:mm" id = "end"/></td>
  	<td><span id="enderror"></span></td> 
   </tr>
  </table>
   <br>
  <button type="submit">Add Appointment</button>  
 </form:form>
 </div>
  <script type = "text/javascript"> 
  var rdate = /^(202\d{1}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d{1}|3[01]))$/;
  var rtime = /^([0-1][0-9]|[2][0-3]):([0-5][0-9])$/;
  
      function validate() {
      
         if( !(document.getElementById('date').value).match(rdate) ) {
            document.getElementById('dateerror').innerHTML = "Please fill in the Date in proper Format";
            return false;
         }
         else document.getElementById('dateerror').innerHTML = "";
         
         if( !(document.getElementById('begin').value).match(rtime) ) {
             document.getElementById('beginerror').innerHTML = "Please fill the Begin-time in Correct Format";
             return false;
          }
         else document.getElementById('beginerror').innerHTML = "";
         
         if( !(document.getElementById('end').value).match(rtime) ) {
             document.getElementById('enderror').innerHTML = "Please fill the End-time in Correct Format";
             return false;
          }
         else document.getElementById('enderror').innerHTML = "";
         
     return true;
      }
</script>
</body>
</html>
