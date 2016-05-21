package com.heygis.dao;

import java.sql.ResultSet;
import java.util.List;

import com.heygis.beans.FeedbackMsg;

public interface FeedbackDAO {
	public void addMsg(FeedbackMsg feedbackMsg);
	public ResultSet getMsg();
}
