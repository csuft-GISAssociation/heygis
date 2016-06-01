package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumPostPage;
import com.heygis.dao.DB.DBConnection;
import com.heygis.dao.interfaces.ForumPostDAO;

public class ForumPostDAOImpl extends DAOSupport implements ForumPostDAO {

	@Override
	public synchronized boolean addPost(ForumPost post) {
		String sql = "select count(pid) from forum_post;";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
		int pid = 0;
		try {
			if(rs.next())
				pid = rs.getInt(1)+1;
//			System.out.println("pid="+pid);
			sql = "insert into forum_post (pid,fid,tid,first,author,author_uid,author_account"
					+ ",subject,dateline,message,userip,attachment) values (?,?,?,?,?,?,?,?,?,?,?,?);";
			if(this.execUpdate(sql, pid ,post.getFid(),post.getTid(),post.getFirst(),post.getAuthor(),
					post.getAuthorUid(),post.getAuthorAccount(),post.getSubject(),new Date().getTime(),post.getMessage(),
					post.getUserip(),post.getAttchment()) == 1){
				sql = "update forum_thread SET lastpost=? ,lastposter=? ,replies=replies+1 where tid=?;";
				this.execUpdate(sql, new Date().getTime(),post.getAuthor(),post.getTid());
				this.close();
				return true;
			}else{
				this.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delPost(int pid) {
		String sql = "update forum_post set message=? where pid=?;";
		this.openConn();
		if(this.execUpdate(sql, "此楼被删除", pid) == 1){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ForumPostPage getPostPage(int tid, int page) {
		int begin = page * 30 + -30;
		int end = page * 30;
		String sql = "select * from forum_post where tid=? limit ?,?;";
		this.openConn();
		ResultSet rs = this.execQuery(sql, tid, begin, end);
		ForumPostPage postPage = new ForumPostPage(tid,page);
		postPage.setTid(tid);
		int i = 0;
		try {
			while(rs.next()){
				postPage.setPost(i, new ForumPost(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(5),
						rs.getInt(6), 
						rs.getString(7),
						rs.getString(8),
						new Date(rs.getLong(9)),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getInt(13)));
				i++;
//				System.out.println(i+","+begin+","+end);
			}
			sql = "update forum_thread SET views=views+1 where tid=?;";
			this.execUpdate(sql, tid);
			this.close();
			return postPage;
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
		return null;
	}
}
