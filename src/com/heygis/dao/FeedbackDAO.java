package com.heygis.dao;

import java.util.List;

import com.heygis.beans.FeedbackMsg;

public interface FeedbackDAO {
	public boolean addMsg(FeedbackMsg feedbackMsg);
	public List<FeedbackMsg> getMsg();
}
