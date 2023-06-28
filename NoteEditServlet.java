package com.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import com.DB.DBConnect;
import com.DAO.PostDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		
		try 
		{
			Integer noteid=Integer.parseInt(request.getParameter("noteid"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			PostDAO dao=new PostDAO(DBConnect.getConn());
			boolean f=dao.postUpdate(noteid,title,content);
			if(f)
			{
				System.out.println("updated successful");
				HttpSession session=request.getSession();
				session.setAttribute("updateMsg","Notes Updated successfully..");
				response.sendRedirect("showNotes.jsp");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
