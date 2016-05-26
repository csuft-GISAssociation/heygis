package com.heygis.dao.interfaces;

import com.heygis.beans.ForumPost;

public interface ForumPostDAO {
	public boolean addPost(ForumPost post);
	public boolean delPost(int pid);
}
