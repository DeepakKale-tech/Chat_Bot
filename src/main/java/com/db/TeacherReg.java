package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Teacher;

/**
 * Servlet implementation class TeacherReg
 */
@WebServlet("/TeacherReg")
public class TeacherReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Name = request.getParameter("tname");
		String Email = request.getParameter("tmail");;
		String Username = request.getParameter("tuser");;
		String Password = request.getParameter("tpass");;
		
		try
		{
			Teacher t = new Teacher();
			t.setTname(Name);
			t.setTmail(Email);
			t.setTuser(Username);
			t.setTpass(Password);
			
			int status = TeacherDao.saveTeacher(t);
			
			if(status > 0)
			{
				System.out.println("Save successfull");
			}
			else
			{
				System.out.println("error occurs");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("TeacherLogin.jsp");
	}

}
