package com.heygis.dao.interfaces;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.dao.DAOSupport;
import com.heygis.dao.FeedbackDAO;

public class FeedbackDAOImpl extends DAOSupport implements FeedbackDAO{

	@Override
	public void addMsg(FeedbackMsg feedbackMsg) {
		String account = feedbackMsg.getAccount();
		String nickname = feedbackMsg.getNickname();
		String time = feedbackMsg.getTime();
		String feedbackContent = feedbackMsg.getFeedbackContent();
		String accountImg = feedbackMsg.getAccountImg();
		String sql = "insert into feedback (account,nickname,time,feedbackcontent,accountimg) values (?,?,?,?,?) ";
//		String s1 = "insert into feedback (account,nickname,time,feedbackcontent,accountimg) values ('"+account+"','" +
//				nickname+"','"+
//				time+"','"+
//				feedbackContent+"','"+
//				accountImg+"')";
		int result = this.execUpdate(sql, account,nickname,time,feedbackContent,accountImg);
		if(result == 1){
			System.out.println("反馈成功");
		}else{
			System.out.println("反馈失败");
		}
	}

	@Override
	public ResultSet getMsg() {
		String sql ="select * from feedback order by id desc";
		ResultSet rs = this.execQuery(sql);
		return rs;
	}

}
