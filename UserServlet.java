package com.Servlet;
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
@WebServlet("/UserServlet")
public class UserServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
{
	String name=req.getParameter("fname");
	String email=req.getParameter("uemail");
	String password=req.getParameter("upassword");
	
	UserDetails us=new UserDetails();
	us.setName(name);
	us.setEmail(email);
	us.setPassword(password);
	
	UserDAO dao=new UserDAO(DBConnect.getConn());
	boolean f=dao.addUser(us);
	//PrintWriter out=resp.getWriter();
	HttpSession session;
	if(f)
	{
		
		//out.print("User Registered Successfully");
		 session=req.getSession();
		session.setAttribute("reg-success","Registered Sucessfully....");
		resp.sendRedirect("register.jsp");
		
	}
	else
	{
		 session=req.getSession();
			session.setAttribute("failed-msg","Something went wrong....");
		//out.print("User not registered");
			resp.sendRedirect("register.jsp");
	}
}
}
