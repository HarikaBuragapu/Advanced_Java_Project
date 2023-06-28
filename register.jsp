<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@include file="all_component/allcss.jsp" %>

</head>
<body>
<div class="container-fluid div-color">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card mt-5 mr-6">
<div class="card-header text-center text-white bg-custom">
<i class="fa fa-user-plus fa-3x " aria-hidden="true"></i>
<h1>Register</h1>
</div>




<% 
String regmsg=(String)session.getAttribute("reg-success");
if(regmsg!=null)
{%><div class="alert alert-success" role="alert">
	 <%=regmsg %>Login<a href="login.jsp">Click Here</a>
	</div>
	<%
	session.removeAttribute("reg-success");
}
%>

<% 
String failedmsg=(String)session.getAttribute("failed-msg");
if(failedmsg!=null)
{%><div class="alert alert-danger" role="alert">
  <%=failedmsg %>
</div>
	<%
	session.removeAttribute("failed-msg");	
}
%>


<div class="card-body">
<form action="UserServlet" method="post">
 <div class="form-group">
    <label>Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username" name="fname">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="uemail">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="upassword">
  </div>
 
  <button type="submit" class="btn btn-primary badge-pill btn-block">REGISTER</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>