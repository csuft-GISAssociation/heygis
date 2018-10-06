package com.heygis.service.interfaces;

import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumPostPage;

public interface ForumsPostService {
    /**
     * 新增帖子post
     * @param post
     * @param t_uid
     * @return
     */
    public int addPost(ForumPost post, int t_uid);

    /**
     * 添加帖子回复
     * @param post
     * @param fmsg
     * @param t_uid
     * @param author_uid
     * @return
     */
    public boolean addReplyPost(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid);

    /**
     * 根据pid获取post的内容
     * @param pid
     * @return
     */
    public String getPostMessage(int pid);

    /**
     * 按page获取一页的帖子话题topic
     *
     * @param tid
     * @param page
     * @return
     */
    public ForumPostPage getPostPage(int tid, int page);
}
