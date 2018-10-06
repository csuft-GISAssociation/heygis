package com.heygis.service.interfaces;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;

public interface ForumsThreadService {

    /**
     * 根据板块fid，获取一页的thread
     * @param fid
     * @param page
     * @return
     */
    public ForumsThreadPage getThreadPage(int fid, int page);

    /**
     * 新增帖子thread
     * @param thread
     * @param post
     * @return
     */
    public boolean addthread(ForumThread thread, ForumPost post);

    /**
     * 根据uid获取用户发过的帖子，page分页
     * @param uid
     * @param page
     * @return
     */
    public String getMyThread(int uid, int page);
}
