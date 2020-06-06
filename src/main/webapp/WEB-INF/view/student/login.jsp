<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>BlackBoard - Login</title>
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
<h1>Welcome Student</h1>
<br>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            
 <spring:url value="/student/verify" var="saveURL" />
 
 <form:form class="form-signin" action="${saveURL }" method="POST" modelAttribute="StudentForm">
   <table>
   <tr class="form-label-group">
    <td><label for="email">Email address:&nbsp;</label></td>
    <td><form:input path="email" placeholder="Email address" /></td>
   </tr>
   <tr class="form-label-group">
    <td><label for="Password">Password:</label></td>
    <td><form:input path="password" placeholder="Password" type="password"/></td>
   </tr>  
   <tr>
    <td></td>
    <td><button type="submit">Sign-in</button></td>
   </tr>
  </table>                     
 </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>