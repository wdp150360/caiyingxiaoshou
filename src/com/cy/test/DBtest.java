package com.cy.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cy.utils.DBUtil;

public class DBtest {
	public static void main(String[] args) throws SQLException{
		String sql = "select count(*) as id from customerProduct";
		Connection con = new DBUtil().getCon();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		 int nRow = rs.getInt("id");
//		int nRow = 0;
//		try{
//			ResultSet rs = statement.executeQuery(sql);
//			
//			while(rs.next()){//遍历
//                nRow++;
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
		System.out.println(nRow);
			
	}
}
