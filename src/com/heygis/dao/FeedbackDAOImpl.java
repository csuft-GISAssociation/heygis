package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.dao.interfaces.FeedbackDAO;

public class FeedbackDAOImpl extends DAOSupport implements FeedbackDAO{

	@Override
	public boolean addMsg(FeedbackMsg feedbackMsg) {
		String account = feedbackMsg.getAccount();
		//String nickname = feedbackMsg.getNickname();
		String time = feedbackMsg.getTime();
		String feedbackContent = feedbackMsg.getFeedbackContent();
		//String accountImg = feedbackMsg.getAccountImg();
		String sql = "insert into feedback (account,time,feedbackcontent) values (?,?,?) ";
		this.openConn();
//		String s1 = "insert into feedback (account,nickname,time,feedbackcontent,accountimg) values ('"+account+"','" +
//				nickname+"','"+
//				time+"','"+
//				feedbackContent+"','"+
//				accountImg+"')";
		int result = this.execUpdate(sql, account,time,feedbackContent);
		this.close();
		if(result == 1){
//			System.out.println("�����ɹ�");
			return true;
		}else{
//			System.out.println("����ʧ��");
			return false;
		}
	}

	@Override
	public List<FeedbackMsg> getMsg() {
		String sql ="select feedback.*,users_info.nickname,users_info.icon_img from feedback,users_info where feedback.account = users_info.account order by id desc";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
		List<FeedbackMsg> feedbackMsgList = new ArrayList<FeedbackMsg>();
		try {
			while(rs.next()){
				FeedbackMsg feedbackMsg = new FeedbackMsg();
				feedbackMsg.setAccount(rs.getString("account"));
				feedbackMsg.setNickname(rs.getString("nickname"));
				feedbackMsg.setTime(rs.getString("time"));
				feedbackMsg.setFeedbackContent(rs.getString("feedbackcontent"));
				feedbackMsg.setAccountImg(rs.getString("icon_img"));
				feedbackMsgList.add(feedbackMsg);
			}
			this.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackMsgList;
	}

}
