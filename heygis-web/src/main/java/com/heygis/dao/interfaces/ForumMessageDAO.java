package com.heygis.dao.interfaces;

import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumMsgPage;

public interface ForumMessageDAO {
	int howManyMsg(int uid);
	int howManyNewMsg(int uid);
	int howManyOldMsg(int uid);
	boolean addMsg(int type,ForumMessage m);
	boolean makeMsgOld(int mid);
	ForumMessage getMsg(int mid);
	ForumMsgPage getMsgPage(int uid, int page, int n);
}
