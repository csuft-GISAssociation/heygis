package com.heygis.service;

import com.heygis.beans.ForumPostPage;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumPostDAO;

public class ReplyPostService {
private ForumPostDAO postDAO = null;
	
	public ReplyPostService(){
		postDAO = new ForumPostDAOImpl();
	}
	public String getPostMessage(int pid){
		return postDAO.getPostMessage(pid);
	}
}
