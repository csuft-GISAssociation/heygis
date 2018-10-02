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
    public boolean addThread(ForumThread thread, ForumPost post);

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

    public ForumsThreadPage getThreadPage(int fid, int page);

    public ForumsThreadPage getThreadPageByUid(int uid, int page);

}
