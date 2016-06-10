package com.heygis.service;

import com.heygis.beans.ForumMessage;
import com.heygis.beans.ForumPost;
import com.heygis.dao.ForumMessageDAOImpl;
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
    
    public int addPost(ForumPost post, int t_uid, String subject){
    	int posi = AddPostServiceHolder.INSTANCE.getFpdi().addPost(post);
    	if(posi != 0){
    		ForumMessage fmsg = new ForumMessage(post.getAuthor(), t_uid, subject, post.getDateline().getTime(), 1, post.getFid(), post.getTid());
    		fmsg.setPosition(posi);
    		if(new ForumMessageDAOImpl().addMsg(1, fmsg)){
    			return posi;
    		}
    	}
    	return 0;
    }
}
