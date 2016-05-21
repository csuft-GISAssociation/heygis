package com.heygis.dao.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnection {
	private static DBConnection dbConn = null;
	private BasicDataSource ds = null;
	
	private DBConnection(){
		ds = new BasicDataSource();
		ds.setDriverClassName(DBConfig.getDriverName());
		ds.setUrl(DBConfig.getUrl());
		ds.setUsername(DBConfig.getUserName());
		ds.setPassword(DBConfig.getPassword());
	}
	public static DBConnection getInstance(){
		if(dbConn == null){
			dbConn = new DBConnection();
		}
		return dbConn;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = this.ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();// ��������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
