package com.heygis.service;

import com.heygis.beans.ForumPostPage;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumPostDAO;

public class TopicsService {
	private ForumPostDAO postDAO = null;
	
	public TopicsService(){
		postDAO = new ForumPostDAOImpl();
	}
	public ForumPostPage getPostPage(int tid, int page){
		return postDAO.getPostPage(tid, page);
	}
}
