package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.Teacher;

/**
 * Servlet implementation class TeacherLog
 */
@WebServlet("/TeacherLog")
public class TeacherLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("tuser");
		String password = request.getParameter("tpass");
		
		String role = "TEACHER";
		try
		{
			Teacher t = TeacherDao.getTeacherUser(username);
			
			if(t!=null && t.getTpass().equals(password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("userId", t.getTid());
				session.setAttribute("role", role); // STUDENT or TEACHER
				session.setAttribute("name", t.getTname());
				

				response.sendRedirect("TeacherDashboard.jsp");
			}
			else
			{
				System.out.println("error occurs");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
