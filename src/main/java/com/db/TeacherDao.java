package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.model.Teacher;

public class TeacherDao {

	public static int saveTeacher(Teacher t)
	{
		String sql = "insert into teacher(tname,tmail,tuser,tpass) values(?,?,?,?)";
		int status = 0;
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setString(1, t.getTname());
			ps.setString(2, t.getTmail());
			ps.setString(3, t.getTuser());
			ps.setString(4, t.getTpass());
			
			status = ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public static Teacher getTeacher(int id)
	{
		Teacher t = new Teacher();
		String sql="select * from teacher where tid=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTmail(rs.getString(3));
				t.setTuser(rs.getString(4));
				t.setTpass(rs.getString(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	public static Teacher getTeacherUser(String user)
	{
		Teacher t = new Teacher();
		String sql="select * from teacher where tuser=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTmail(rs.getString(3));
				t.setTuser(rs.getString(4));
				t.setTpass(rs.getString(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	public static List<Teacher> getAllTeachers()
	{
		List<Teacher> list = new ArrayList<Teacher>();
		String sql="select * from teacher";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);)
		{	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Teacher t = new Teacher();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				t.setTmail(rs.getString(3));
				t.setTuser(rs.getString(4));
				t.setTpass(rs.getString(5));
				list.add(t);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}
