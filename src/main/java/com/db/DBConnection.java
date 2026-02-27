package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			//rgister driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatbot","root","root");
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
		return con;
	}
}
