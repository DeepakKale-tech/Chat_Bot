package com.chat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.DBConnection;

/**
 * Servlet implementation class GetMessageServlet
 */
@WebServlet("/GetMessageServlet")
public class GetMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			HttpSession session = request.getSession(false);
			
			
			if(session == null || session.getAttribute("userId") == null){
			    return;
			}
			//String userRole = (String) session.getAttribute("role");
			
			int senderId = (Integer) session.getAttribute("userId");
			String senderRole = (String) session.getAttribute("role");
			
			int receiverId = Integer.parseInt(request.getParameter("receiverId"));
			String receiverRole = senderRole.equals("STUDENT") ? "TEACHER" : "STUDENT";

	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM messages WHERE (sender_id=? AND sender_role=? AND receiver_id=? AND receiver_role=?) OR (sender_id=? AND sender_role=? AND receiver_id=? AND receiver_role=?) ORDER BY timestamp";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, senderId);
	        ps.setString(2, senderRole);
	        ps.setInt(3, receiverId);
	        ps.setString(4, receiverRole);

	        ps.setInt(5, receiverId);
	        ps.setString(6, receiverRole);
	        ps.setInt(7, senderId);
	        ps.setString(8, senderRole);

	        ResultSet rs = ps.executeQuery();

	        
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String myName = (String) session.getAttribute("name");

	        while(rs.next()) {

	            int dbSenderId = rs.getInt("sender_id");
	            String dbSenderRole = rs.getString("sender_role");
	            String message = rs.getString("message");

	            String senderName = "";

	            if(dbSenderRole.equals("STUDENT")) {
	                PreparedStatement psName = con.prepareStatement(
	                    "SELECT sname FROM student WHERE sid=?");
	                psName.setInt(1, dbSenderId);
	                ResultSet rsName = psName.executeQuery();
	                if(rsName.next()) {
	                    senderName = rsName.getString("sname");
	                }
	                rsName.close();
	                psName.close();
	            } else if(dbSenderRole.equals("TEACHER")) {
	                PreparedStatement psName = con.prepareStatement(
	                    "SELECT tname FROM teacher WHERE tid=?");
	                psName.setInt(1, dbSenderId);
	                ResultSet rsName = psName.executeQuery();
	                if(rsName.next()) {
	                    senderName = rsName.getString("tname");
	                }
	                rsName.close();
	                psName.close();
	            }
	            
	            String formattedRole = dbSenderRole.substring(0, 1).toUpperCase() + dbSenderRole.substring(1);
	            
	            out.println(formattedRole + ": " + senderName + " - "
	                    + message + "<br>");
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
