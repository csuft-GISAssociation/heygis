package com.heygis.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.dao.DAOSupport;
import com.heygis.dao.FeedbackDAO;

public class FeedbackDAOImpl extends DAOSupport implements FeedbackDAO{

	@Override
	public boolean addMsg(FeedbackMsg feedbackMsg) {
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
			return true;
		}else{
			System.out.println("反馈失败");
			return false;
		}
	}

	@Override
	public List<FeedbackMsg> getMsg() {
		String sql ="select * from feedback order by id desc";
		ResultSet rs = this.execQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackMsgList;
	}

}
