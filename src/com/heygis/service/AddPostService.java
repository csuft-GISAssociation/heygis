package com.heygis.service;

import com.heygis.dao.ForumPostDAOImpl;

public class AddPostService {
	private static ForumPostDAOImpl fpdi = new ForumPostDAOImpl();
	public ForumPostDAOImpl getFpdi(){
		return fpdi;
	}
	private static class AddPostServiceHolder {  
		private static final AddPostService INSTANCE = new AddPostService();  
	}
	private AddPostService (){}   
    public static final AddPostService getInstance() {    
       return AddPostServiceHolder.INSTANCE;    
    }
}
