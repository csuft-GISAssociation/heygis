package com.heygis.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.dao.interfaces.FeedbackDAOImpl;

public class FeedbackService {
	FeedbackDAOImpl fdi = null;
	public FeedbackService(){
		fdi = new FeedbackDAOImpl();
	}
	public void addMsg(FeedbackMsg feedbackMsg){
		fdi.addMsg(feedbackMsg);
	}
	public List<FeedbackMsg> getMsg(){
		ResultSet rs = fdi.getMsg();
		List<FeedbackMsg> feedbackMsgList = new ArrayList<FeedbackMsg>();
		try {
			while(rs.next()){
				FeedbackMsg feedbackMsg = new FeedbackMsg();
				feedbackMsg.setAccount(rs.getString("account"));
				feedbackMsg.setNickname(rs.getString("nickname"));
				feedbackMsg.setTime(rs.getString("time"));
				feedbackMsg.setFeedbackContent(rs.getString("feedbackcontent"));
				feedbackMsg.setAccountImg(rs.getString("accountimg"));
				feedbackMsgList.add(feedbackMsg);
			}
			return feedbackMsgList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
