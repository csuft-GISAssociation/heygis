package com.heygis.service;

import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;
import com.heygis.dao.ForumThreadDAOImpl;
import com.heygis.dao.interfaces.ForumThreadDAO;

public class ForumsService {
	ForumThreadDAO forumThreadDAO = null;
	public ForumsService(){
		forumThreadDAO = new ForumThreadDAOImpl();
	}
	public ForumsThreadPage getThreadPage(int fid, int page){
		return forumThreadDAO.getThreadPage(fid, page);
	}
	public boolean addthread(ForumThread thread, ForumPost post){
		return forumThreadDAO.addThread(thread, post);
	}
	public String getMyThread(int uid, int page){
		ForumsThreadPage threadPage = forumThreadDAO.getThreadPageByUid(uid, page);
		JSONObject tl = new JSONObject();
		JSONArray threadArray = new JSONArray();
		try {
			tl.put("size", threadPage.getSize());
			tl.put("page", threadPage.getPage());
			JSONObject thread;
			for(int i=0;i<threadPage.getSize();i++){
				thread = new JSONObject();
				thread.put("tid", threadPage.getThread(i).getTid());
				thread.put("subject", threadPage.getThread(i).getSubject());
				thread.put("dateline", new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(threadPage.getThread(i).getDateline()));
				thread.put("lastpost", threadPage.getThread(i).getLastpost());
				thread.put("lastposter", threadPage.getThread(i).getLastposter());
				thread.put("views", threadPage.getThread(i).getViews());
				thread.put("replies", threadPage.getThread(i).getReplies());
				thread.put("close", threadPage.getThread(i).getClose());
				thread.put("displayorer", threadPage.getThread(i).getDisplayorer());
				threadArray.put(thread);
			}
			tl.put("threadArray", threadArray);
		}catch(Exception e){
			e.printStackTrace();
		}
		return tl.toString();
	}
}
