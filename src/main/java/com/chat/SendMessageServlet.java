package com.chat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.DBConnection;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SendMessageServlet called");
		System.out.println("Sender: " + request.getParameter("senderId"));
		System.out.println("Receiver: " + request.getParameter("receiverId"));
		System.out.println("Text: " + request.getParameter("text"));

		
		try {
			String senderStr = request.getParameter("senderId");
			String receiverStr = request.getParameter("receiverId");

			

			HttpSession session = request.getSession(false);
			
			
			if(session == null || session.getAttribute("userId") == null){
			    return;
			}
			
			int senderId = (Integer) session.getAttribute("userId");
			String senderRole = (String) session.getAttribute("role");
			
			int receiverId = Integer.parseInt(request.getParameter("receiverId"));
			String receiverRole = senderRole.equals("STUDENT") ? "TEACHER" : "STUDENT";
			
			
			//int senderId = Integer.parseInt(request.getParameter("senderId"));
			//int receiverId = Integer.parseInt(request.getParameter("receiverId"));
			
			String text = request.getParameter("text");
			
			Connection con = DBConnection.getConnection();

			String sql = "INSERT INTO messages (sender_id, sender_role, receiver_id, receiver_role, message) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, senderId);
			ps.setString(2, senderRole);
			ps.setInt(3, receiverId);
			ps.setString(4, receiverRole);  // pass from request
			ps.setString(5, text);

			ps.executeUpdate();

			con.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
