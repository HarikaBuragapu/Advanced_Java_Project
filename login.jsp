<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="all_component/allcss.jsp" %>

</head>
<body>
<div class="container-fluid div-color">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card mt-5 mr-6">
<div class="card-header text-center text-white bg-custom">
<i class="fa fa-user fa-3x " aria-hidden="true"></i>
<h1>Login</h1>
</div>


  <% 
  String invalid=(String)session.getAttribute("login-failed");
  if(invalid!=null)
  {%>
  <div class="alert alert-danger" role="alert">
  <%=invalid %>
  </div>
  <%
	  session.removeAttribute("login-failed");
  }
  %>
   
  <%
     String withoutLogin=(String)session.getAttribute("login-error"); 
  	 if(withoutLogin!=null)
  	 {%>
  	 
  	 <div class="alert alert-danger" roles="alert"><%=withoutLogin%></div>
	 
  	 <%
  	session.removeAttribute("login-error");
  	 }
  %>
  
  <%
  
  String logout=(String)session.getAttribute("logoutMsg");
  if(logout!=null)
  {
	  %>
	    <div class="alert alert-success" roles="alert"><%=logout%></div>
	  <%
	  	session.removeAttribute("logoutMsg");

  }
  %>
  
  
  

<div class="card-body">
<form action="loginServlet" method="post">



  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="uemail" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="upassword">
  </div>
 
  <button type="submit" class="btn btn-primary badge-pill btn-block">LOGIN</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>