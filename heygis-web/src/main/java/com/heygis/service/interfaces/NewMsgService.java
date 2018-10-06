package com.heygis.service.interfaces;

import com.heygis.dto.ForumMsgPage;

public interface NewMsgService {

    public int howManyNewMsg(int uid);

    public int howManyOldwMsg(int uid);

    public ForumMsgPage getMsgPage(int uid, int page, int n);

    public String getMsgList(int uid, int page, int n);

    public boolean makeMsgOld(int mid);
}
