package com.heygis.service;

import com.heygis.beans.ForumMsgPage;
import com.heygis.dao.ForumMessageDAOImpl;
import com.heygis.dao.interfaces.ForumMessageDAO;

public class NewMsgService {
	ForumMessageDAO fMsgDAO;
	public NewMsgService(){
		fMsgDAO = new ForumMessageDAOImpl();
	}
	public int howManyNewMsg(int uid){
		return fMsgDAO.howManyNewMsg(uid);
	}
	public int howManyOldwMsg(int uid){
		return fMsgDAO.howManyOldMsg(uid);
	}
	public ForumMsgPage getMsgPage(int uid,int page, int n){
		return fMsgDAO.getMsgPage(uid, page, n);
	}
}
