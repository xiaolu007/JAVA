package com.xiaolu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Util;
import com.xiaolu.entity.*;
//import java.io.File;
import com.xiaolu.util.DBUtil;

public class FileService {
	public void insert(File file) {
		PreparedStatement pst = null;
		Connection conn = DBUtil.getconn();
		String sql = "insert into tb_file (fname,fcontent) values (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, file.getFname());
			pst.setBytes(2, file.getFcontent());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.addClose(pst, conn);
		}
		
	}
	
}
