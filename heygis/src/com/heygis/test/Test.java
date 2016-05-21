package com.heygis.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.heygis.dao.DB.DBConnection;

public class Test {
	public static void main(String[]args) throws SQLException{
		DBConnection DBconn = DBConnection.getInstance();
		for (int i = 0; i < 5; i++) {
			long t1 = System.currentTimeMillis();
			Connection conn = DBconn.getConnection();
			conn.close();
			long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
		}
		
		
	}
}
