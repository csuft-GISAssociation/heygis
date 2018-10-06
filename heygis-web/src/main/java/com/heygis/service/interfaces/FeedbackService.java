package com.heygis.service.interfaces;

import com.heygis.dto.FeedbackMsg;

import java.util.List;

public interface FeedbackService {

    public boolean addMsg(FeedbackMsg feedbackMsg);

    public List<FeedbackMsg> getMsg();
}
