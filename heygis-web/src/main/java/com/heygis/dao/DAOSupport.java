package com.heygis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.dao.DB.DBConnection;

public class DAOSupport {
	static int times = 0;
	protected ResultSet rs = null;
	protected PreparedStatement stmt = null;
	protected DBConnection dbconn = null;
	protected Connection conn = null;

	protected ResultSet execQuery(String sql, Object... args) {
		try {
//			openConn();
			stmt = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++){
				stmt.setObject(i+1, args[i]);
			}
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	protected int execUpdate(String sql, Object... args) {
		try {
//			openConn();
			stmt = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++){
				stmt.setObject(i+1, args[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	protected void openConn(){
		System.out.println(++times + "open");
		try {
			dbconn = DBConnection.getInstance();
			conn = dbconn.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		System.out.println(times + "close");
		dbconn.close(conn, stmt, rs);
	}
	protected int LAST_INSERT_ID() {
		try {
			stmt = conn.prepareStatement("SELECT LAST_INSERT_ID();");
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);//取得ID
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
