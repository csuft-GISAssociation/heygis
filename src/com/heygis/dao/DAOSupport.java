package com.heygis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.dao.DB.DBConnection;

public class DAOSupport {
	protected ResultSet rs = null;
	protected PreparedStatement stmt = null;
	protected DBConnection dbconn = null;
	protected Connection conn = null;

	protected ResultSet execQuery(String sql, Object... args) {
		try {
			openConn();
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
			openConn();
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
	private void openConn(){
		try {
			dbconn = DBConnection.getInstance();
			conn = dbconn.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		dbconn.close(conn, stmt, rs);
	}
}
