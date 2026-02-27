package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.Student;
import com.model.Teacher;

/**
 * Servlet implementation class StudentLog
 */
@WebServlet("/StudentLog")
public class StudentLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("suser");
		String password = request.getParameter("spass");
		
		String role = "STUDENT";
		try
		{
			Student s = StudentDao.getStudentUser(username);
			
			if(s!=null && s.getSpass().equals(password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("userId", s.getSid());
				session.setAttribute("role", role); // STUDENT or TEACHER
				session.setAttribute("name", s.getSname());
				
				
				
				response.sendRedirect("StudentDashboard.jsp");
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
