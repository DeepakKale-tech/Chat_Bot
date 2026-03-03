package com.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.Student;
import com.model.Teacher;

/**
 * Servlet implementation class StudentReg
 */
@WebServlet("/StudentReg")
public class StudentReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = request.getParameter("sname");
		String Email = request.getParameter("smail");;
		String Username = request.getParameter("suser");;
		String Password = request.getParameter("spass");;
		
		try
		{
			Student s = new Student();
			s.setSname(Name);
			s.setSmail(Email);
			s.setSuser(Username);
			s.setSpass(Password);
			
			int status = StudentDao.saveStudent(s);
			
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
		response.sendRedirect("StudentLogin.jsp");
	}

}
