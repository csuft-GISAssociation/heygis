package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumPostPage;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.heygis.dao.interfaces.ForumThreadDAO;
import com.heygis.service.AddPostService;

public class ForumThreadDAOImpl extends DAOSupport implements ForumThreadDAO {

	@Override
	public boolean addThread(ForumThread thread, ForumPost post) {
		String sql = "insert into forum_thread (fid,typeid,sortid,author,author_uid,"
				+ "author_account,subject,dateline,lastpost,attachment)values(?,?,?,?,?,?,?,?,?,?);";
		this.openConn();
		if(this.execUpdate(sql, thread.getFid(),thread.getTypeid(),thread.getSortid(),thread.getAuthor(),
				thread.getAuthorUid(),thread.getAuthorAuthor(),thread.getSubject(),new Date().getTime(),
				new Date().getTime(),thread.getAttachment())==1){
			int tid = this.LAST_INSERT_ID();
//			System.out.println(tid);
			this.close();
			post.setTid(tid);
			AddPostService aps = AddPostService.getInstance();
			aps.getFpdi().addPost(post);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delThread(int tid) {
		String sql = "update forum_thread display=0 where tid=?;";
		this.openConn();
		if(this.execUpdate(sql,tid) == 1){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}

	@Override
	public ForumsThreadPage getThreadPage(int fid, int page) {
		int begin = (page-1) * 30;
		int end = 30 ;
		String sql = "select forum_thread.*,users_info.nickname from forum_thread,users_info "
				+ "where forum_thread.author_uid=users_info.uid and fid=? and display=1 order by lastpost DESC limit ?,?;";
		this.openConn();
		ResultSet rs = this.execQuery(sql, fid, begin, end);
		ForumsThreadPage threadPage = new ForumsThreadPage(fid,page);
		int i = 0;
		try{
			while(rs.next()){
				threadPage.setThread(i, new ForumThread(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(18), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8), 
						new Date(rs.getLong(9)),
						new Date(rs.getLong(10)),
						rs.getString(11), 
						rs.getInt(12), 
						rs.getInt(13), 
						rs.getInt(14), 
						rs.getInt(15), 
						rs.getInt(16), 
						rs.getInt(17)));
				i++;
			}
//			System.out.println("has closed");
			this.close();
			return threadPage;
		}catch(Exception e){
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

}
