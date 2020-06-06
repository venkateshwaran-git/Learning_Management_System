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
<style>
body {
  background-color: linen;  
}

</style>
</head>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://www.pngitem.com/pimgs/m/4-43262_school-png-photo-transparent-school-logo-png-png.png" width="50" height="50" class="d-inline-block align-top" alt="">
    <span  class="navbar-brand ">BlackBoard</span> 
  </a>
</nav>

<body id="main">
<div class="container">
<br>
<h1>Welcome</h1>
<br>

<div class="row">

<div class="col-sm-6">
<div class="card" style="width: 18rem;">
  <img src="https://compote.slate.com/images/6188b2c2-146a-420a-b41e-0d59f549dc40.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h3 class="card-text">Login as teacher <a href="/Skl_Administration/teacher/login">here</a></h3>
    <h3 class="card-text">Register as teacher <a href="/Skl_Administration/teacher/add">here</a></h3>
  </div>
</div>
</div>

<div class="col-sm-6">
<div class="card" style="width: 18rem;">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSJmRVmt8BK-3KPdpVWfXTbfuSYTOzv5fm622C_6QEdY4e6rIEv&usqp=CAU" class="card-img-top" alt="...">
  <div class="card-body">
    <h3 class="card-text">Login as student <a href="/Skl_Administration/student/login">here</a></h3>
    <h3 class="card-text">Register as student <a href="/Skl_Administration/student/add">here</a></h3>
  </div>
</div>
</div>
</div>
</div>
</body>
</html>