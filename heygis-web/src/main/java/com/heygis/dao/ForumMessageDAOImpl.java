package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumMsgPage;
import com.heygis.dao.interfaces.ForumMessageDAO;

public class ForumMessageDAOImpl extends DAOSupport implements ForumMessageDAO {

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
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.close();
		return num;
	}

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
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}

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
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.close();
		return num;
	}

	public boolean addMsg(int type, ForumMessage m) {
		String sql = "insert into forum_msg (author,author_uid,rd_uid,subject,dateline,type,fid,tid,position)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		this.openConn();
		int num = this.execUpdate(sql, m.getAuthor(),m.getAuthor_uid(),m.getRd_uid(),m.getSubject(),m.getDateline(),m.getType(),m.getFid(),m.getTid(),m.getPosition());
		this.close();
		if( num == 1){
			return true;
		}
		return false;
	}

	public boolean makeMsgOld(int mid) {
		String sql = "update forum_msg set new=0 where mid=?;";
		this.openConn();
		int num =this.execUpdate(sql, mid);
		this.close();
		if(num == 1){
			return true;
		}
		return false;
	}

	public ForumMsgPage getMsgPage(int uid, int page, int n) {
		ForumMsgPage fmPage = new ForumMsgPage(uid,page);
		int begin = (page-1)*20;
		int end = 20;
		String sql = "select msg.*,uinfo.nickname from forum_msg msg,users_info uinfo where msg.rd_uid=? and msg.new=? and uinfo.uid=msg.author_uid order by msg.dateline desc limit ?,?;;";
//		String sql = "select * from forum_msg where rd_uid=? and new=? order by dateline desc limit ?,?;";
		this.openConn();
		ResultSet rs = this.execQuery(sql, uid, n, begin, end);
		try {
			while(rs.next()){
				fmPage.addMsg(new ForumMessage(
						rs.getInt("mid"),
						rs.getString("nickname"),
						rs.getInt("author_uid"),
						rs.getInt("rd_uid"),
						rs.getString("subject"),
						rs.getLong("dateline"),
						rs.getInt("type"),
						rs.getInt("fid"),
						rs.getInt("tid"),
						rs.getInt("position")));
			}
			this.close();
			return fmPage;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(!this.conn.isClosed())
					this.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ForumMessage getMsg(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
