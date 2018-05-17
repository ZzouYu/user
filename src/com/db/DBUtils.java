package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=UTF-8";
	String user = "root";
	String password = "123123";
	Connection conn = null;
	
	public  Connection getCon() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(url,user,password);
			return conn ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null ;
	}
}