package com.heygis.dao.interfaces;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumPostPage;

public interface ForumPostDAO {

    public int addPost(ForumPost post);

    public boolean delPost(int pid);

    public ForumPostPage getPostPage(int tid, int page);

    public String getPostMessage(int tid);
}
