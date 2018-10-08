package com.heygis.service;

import java.util.List;

import com.heygis.dao.interfaces.FeedbackDAO;
import com.heygis.dto.FeedbackMsg;
import com.heygis.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackDAO feedbackDAO = null;

    public boolean addMsg(FeedbackMsg feedbackMsg) {
        return feedbackDAO.addMsg(feedbackMsg);
    }

    public List<FeedbackMsg> getMsg() {
        return feedbackDAO.getMsg();

    }
}
