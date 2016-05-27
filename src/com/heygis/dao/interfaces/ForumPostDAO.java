package com.heygis.dao.interfaces;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumPostPage;

public interface ForumPostDAO {
	public boolean addPost(ForumPost post);
	public boolean delPost(int pid);
	public ForumPostPage getPostPage(int tid, int page);
}
