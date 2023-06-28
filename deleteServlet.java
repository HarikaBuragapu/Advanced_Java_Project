package com.Servlet;
import com.DB.DBConnect;
import com.DAO.PostDAO;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		PostDAO dao=new PostDAO(DBConnect.getConn());
		boolean f=dao.deleteNotes(noteid);
		HttpSession session=null;
		if(f)
		{
			session=request.getSession();
			session.setAttribute("deleteMsg","Notes deleted successfully..");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("wrongMsg","Something went wrong");
			response.sendRedirect("showNotes.jsp");

		}
	}



}
