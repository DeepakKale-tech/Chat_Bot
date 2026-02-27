package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.model.Teacher;

public class StudentDao {

	public static int saveStudent(Student s)
	{
		String sql = "insert into student(sname,smail,suser,spass) values(?,?,?,?)";
		int status = 0;
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setString(1, s.getSname());
			ps.setString(2, s.getSmail());
			ps.setString(3, s.getSuser());
			ps.setString(4, s.getSpass());
			
			status = ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Student getStudent(int id)
	{
		Student s = new Student();
		String sql="select * from student where sid=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSmail(rs.getString(3));
				s.setSuser(rs.getString(4));
				s.setSpass(rs.getString(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static Student getStudentUser(String user)
	{
		Student s = new Student();
		String sql="select * from student where suser=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSmail(rs.getString(3));
				s.setSuser(rs.getString(4));
				s.setSpass(rs.getString(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSmail(rs.getString(3));
				s.setSuser(rs.getString(4));
				s.setSpass(rs.getString(5));
				list.add(s);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}
