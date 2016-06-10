package com.heygis.service;

import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumPostPage;
import com.heygis.dao.ForumMessageDAOImpl;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumMessageDAO;
import com.heygis.dao.interfaces.ForumPostDAO;

public class ReplyPostService {
	private ForumPostDAO postDAO = null;
	private ForumMessageDAO msgDAO= null;
	
	public ReplyPostService(){
		postDAO = new ForumPostDAOImpl();
		msgDAO = new ForumMessageDAOImpl();
	}
	public String getPostMessage(int pid){
		return postDAO.getPostMessage(pid);
	}
	public boolean addReplyPost(ForumPost post, ForumMessage fmsg,int t_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			fmsg.setPosition(replyposi);
			if(msgDAO.addMsg(2, fmsg)){
				return true;
			}
		}
		return false;
	}
}
