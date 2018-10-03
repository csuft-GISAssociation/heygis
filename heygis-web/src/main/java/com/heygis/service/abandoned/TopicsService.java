package com.heygis.service.abandoned;

import com.heygis.dto.ForumPostPage;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumPostDAO;

/**
 * 废弃，迁移到ForumPostService
 */
public class TopicsService {
    private ForumPostDAO postDAO = null;

    public TopicsService() {
        postDAO = new ForumPostDAOImpl();
    }

    public ForumPostPage getPostPage(int tid, int page) {
        return postDAO.getPostPage(tid, page);
    }
}
