package com.telusko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public boolean checkCredentials(String username, String password) {
		
		String mysqlDriver = "com.mysql.jdbc.Driver";
		String mysqlUrl = "jdbc:mysql://localhost:3306/navin";
		String mysqlUsername = "root";
		String mysqlPassword = "oracle";
		String query = "select * from login where username=? and password=?";
		try {
			Class.forName(mysqlDriver);
			Connection conn = DriverManager.getConnection(mysqlUrl, mysqlUsername, mysqlPassword);
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
