package com.cy.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
	public Connection getCon(){
		Connection con = null;
		Properties properties = new Properties();
		try{
			properties.load(this.getClass().getResourceAsStream("/conf/dbConfig.properties"));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url, username, password);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return con;

	}
}
