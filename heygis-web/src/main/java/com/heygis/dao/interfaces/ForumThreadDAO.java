package com.heygis.dao.interfaces;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;

public interface ForumThreadDAO {
	public boolean addThread(ForumThread thread, ForumPost post);
	public boolean delThread(int tid);
	public ForumsThreadPage getThreadPage(int fid, int page);
	public ForumsThreadPage getThreadPageByUid(int uid, int page);
}
