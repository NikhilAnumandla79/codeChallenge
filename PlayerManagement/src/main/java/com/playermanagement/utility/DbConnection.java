package com.playermanagement.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	final String dbUser="root";
	final String dbUrl="jdbc:mysql://localhost:3306/playersregistrations";
	final String dbPass="Nikhil@79";
	public Connection getConnection() throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return con;
		
		
		
	}
	
}
