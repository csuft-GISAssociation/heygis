package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumMsgPage;
import com.heygis.dao.interfaces.ForumMessageDAO;

public class ForumMessageDAOImpl extends DAOSupport implements ForumMessageDAO {

	@Override
	public int howManyMsg(int uid) {
		String sql = "select count(*) from forum_msg where rd_uid=?;";
		int num = 0;
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid);
		try {
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return num;
	}

	@Override
	public int howManyNewMsg(int uid) {
		String sql = "select count(*) from forum_msg where rd_uid=? and new=1;";
		int num = 0;
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid);
		try {
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return num;
	}

	@Override
	public int howManyOldMsg(int uid) {
		String sql = "select count(*) from forum_msg where rd_uid=? and new=0;";
		int num = 0;
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid);
		try {
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return num;
	}

	@Override
	public boolean addMsg(int type, ForumMessage m) {
		String sql = "insert into forum_msg (author,rd_uid,subject,dateline,type,fid,tid,position)"
				+ " values (?,?,?,?,?,?,?,?)";
		this.openConn();
		if(this.execUpdate(sql, m.getAuthor(),m.getRd_uid(),m.getSubject(),m.getDateline(),m.getType(),m.getFid(),m.getTid(),m.getPosition()) == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean makeMsgOld(int mid) {
		String sql = "update forum_msg set new=0 where mid=?;";
		this.openConn();
		if(this.execUpdate(sql, mid) == 1){
			return true;
		}
		return false;
	}

	@Override
	public ForumMsgPage getMsgPage(int uid, int page, int n) {
		ForumMsgPage fmPage = new ForumMsgPage(uid,page);
		int begin = (page-1)*20;
		int end = 20;
		String sql = "select * from forum_msg where rd_uid=? and new=? limit ?,?;";
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid, n, begin, end);
		try {
			while(rs.next()){
				fmPage.addMsg(new ForumMessage(
						rs.getInt(1),
						rs.getString(2), 
						rs.getInt(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9)));
			}
			this.close();
			return fmPage;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed()){
					System.out.println("finallclose");}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ForumMessage getMsg(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
