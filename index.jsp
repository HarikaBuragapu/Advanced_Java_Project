<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.DB.DBConnect" %>
   <%@ page import="java.sql.Connection" %>
   
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img
{
width:100;
 background-image:linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("images/notepad.jpeg");
    height:100vh;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
<meta charset="UTF-8">
<title>Home page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid back-img">
<div class="text-center">
<h1 style="color:beige;padding:20px"><i class="fa fa-address-book" aria-hidden="true"></i>E-Notes   Save Your Notes</h1>
<a href="login.jsp" class="btn btn-light">Login</a>
<a href="register.jsp" class="btn btn-light">Register</a>

</div>
</div>
</body>
</html>