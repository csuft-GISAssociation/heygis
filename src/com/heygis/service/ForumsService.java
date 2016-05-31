package com.heygis.service;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;
import com.heygis.dao.ForumThreadDAOImpl;

public class ForumsService {
	ForumThreadDAOImpl ftp = null;
	public ForumsService(){
		ftp = new ForumThreadDAOImpl();
	}
	public ForumsThreadPage getThreadPage(int fid, int page){
		return ftp.getThreadPage(fid, page);
	}
	public boolean addthread(ForumThread thread, ForumPost post){
		return ftp.addThread(thread, post);
	}
}
