package com.heygis.dao.interfaces;

import com.heygis.beans.ForumThread;
import com.heygis.beans.ForumsThreadPage;

public interface ForumThreadDAO {
	public boolean addThread(ForumThread thread);
	public boolean delThread(int tid);
	public ForumsThreadPage getThreadPage(int fid, int page);
}
