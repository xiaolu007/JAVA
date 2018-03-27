package com.xiaolu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * ����mysql���ݿ�
	 */
	public static  Connection getconn()
	{
		Connection conn = null;
		
		String user   = "root";
		String passwd = "root";
		String url = "jdbc:mysql://localhost:3306/file";
		
		//�Ѽ���������
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(url,user,passwd);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	/**
	 * �ر� ��ӹ��� ��Դ
	 * @param pstmt,rs,conn
	 */
	public static void addClose(PreparedStatement pstmt, Connection conn) 
	{
		/*
		 * ��� try-catch �����㣺��ȫ
		 */
		try
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر���Դ
	 * @param pstmt,rs,conn
	 */
	public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn)
	{
		try
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (rs != null )
			{
				rs.close();
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
