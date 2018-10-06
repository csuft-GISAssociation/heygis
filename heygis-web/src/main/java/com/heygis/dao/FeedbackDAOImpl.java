package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.dto.FeedbackMsg;
import com.heygis.dao.interfaces.FeedbackDAO;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDAOImpl extends DAOSupport implements FeedbackDAO {

    public boolean addMsg(FeedbackMsg feedbackMsg) {
        this.openConn();
        String account = feedbackMsg.getAccount();
        //String nickname = feedbackMsg.getNickname();
        String time = feedbackMsg.getTime();
        String feedbackContent = feedbackMsg.getFeedbackContent();
        //String accountImg = feedbackMsg.getAccountImg();
        String sql = "insert into feedback (account,time,feedbackcontent) values (?,?,?) ";
//		String s1 = "insert into feedback (account,nickname,time,feedbackcontent,accountimg) values ('"+account+"','" +
//				nickname+"','"+
//				time+"','"+
//				feedbackContent+"','"+
//				accountImg+"')";
        int result = this.execUpdate(sql, account, time, feedbackContent);
        this.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<FeedbackMsg> getMsg() {
        try {
            this.openConn();

            String sql = "select feedback.*,users_info.nickname,users_info.icon_img from feedback,users_info where feedback.account = users_info.account order by id desc";
            ResultSet rs = this.execQuery(sql);
            List<FeedbackMsg> feedbackMsgList = new ArrayList<FeedbackMsg>();
            while (rs.next()) {
                FeedbackMsg feedbackMsg = new FeedbackMsg();
                feedbackMsg.setAccount(rs.getString("account"));
                feedbackMsg.setNickname(rs.getString("nickname"));
                feedbackMsg.setTime(rs.getString("time"));
                feedbackMsg.setFeedbackContent(rs.getString("feedbackcontent"));
                feedbackMsg.setAccountImg(rs.getString("icon_img"));
                feedbackMsgList.add(feedbackMsg);
            }
            return feedbackMsgList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

}
