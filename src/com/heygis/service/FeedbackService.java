package com.heygis.service;

import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.dao.FeedbackDAOImpl;

public class FeedbackService {
	FeedbackDAOImpl fdi = null;
	public FeedbackService(){
		fdi = new FeedbackDAOImpl();
	}
	public boolean addMsg(FeedbackMsg feedbackMsg){
		return fdi.addMsg(feedbackMsg);
	}
	public List<FeedbackMsg> getMsg(){
		return fdi.getMsg();
		
	}
}
