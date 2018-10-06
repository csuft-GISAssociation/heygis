package com.heygis.dao.interfaces;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;

public interface ForumThreadDAO {

    /**
     * 发帖
     * @param thread
     * @param post
     * @return
     */
    public int addThread(ForumThread thread, ForumPost post);

    /**
     * 删帖
     * @param tid
     * @return
     */
    public boolean delThread(int tid);

    /**
     * 更新最后回帖的信息
     * @param psot
     * @return
     */
    public boolean updateThreadLastPost(ForumPost psot);

    /**
     * 根据fid，page获取一页的Thread
     * @param fid
     * @param page
     * @return
     */
    public ForumsThreadPage getThreadPageByFid(int fid, int page);

    /**
     * uid，page获取一页的Thread
     * @param uid
     * @param page
     * @return
     */
    public ForumsThreadPage getThreadPageByUid(int uid, int page);

    /**
     * 获取一个fid的thread总数
     * @param fid
     * @return
     */
    public int getThreadCountByFid(int fid);

}
