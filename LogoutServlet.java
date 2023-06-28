package com.Servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			HttpSession session=(HttpSession)request.getSession();
			session.removeAttribute("userD");
			
			HttpSession session2=(HttpSession)request.getSession();
			session2.setAttribute("logoutMsg","Logout Sucessfully...");
			
			response.sendRedirect("login.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
