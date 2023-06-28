package com.Servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
String email=request.getParameter("uemail");
String password=request.getParameter("upassword");
UserDetails us=new UserDetails();
us.setEmail(email);
us.setPassword(password);

UserDAO dao=new UserDAO(DBConnect.getConn());
UserDetails user=dao.loginUser(us);
if(user!=null)
{
	HttpSession session=(HttpSession)request.getSession();
	session.setAttribute("userD", user);
	response.sendRedirect("home.jsp");
}
else
{
	HttpSession session=(HttpSession)request.getSession();
	session.setAttribute("login-failed", "invalid username or password");
	response.sendRedirect("login.jsp");
	
}

	}

}
