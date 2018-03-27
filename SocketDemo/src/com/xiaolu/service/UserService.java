package com.xiaolu.service;

import java.nio.charset.MalformedInputException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.xiaolu.entity.User;
import com.xiaolu.util.DBUtil;
import com.xiaolu.util.CommandTransfer;

public class UserService {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void add(User user) {
		conn = DBUtil.getconn();
		String sql="insert into tb_user(username,password) values(?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,user.getUserName());
				pstmt.setString(2, user.getPassWord());
				pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				DBUtil.addClose(pstmt, conn);
			}
	}
	
	public boolean checkstandLog(User user) {
		
		conn = DBUtil.getconn();
		String sql = "select username,password from tb_user where username=? and password=?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.queryClose(pstmt, rs, conn);
		}
		return false;
	}
	
}
