package com.heygis.service.abandoned;

import com.heygis.dao.interfaces.ForumPostDAO;
import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dao.ForumMessageDAOImpl;
import com.heygis.dao.ForumPostDAOImpl;

/**
 * 废弃，迁移到ForumPostService
 */
public class AddPostService {
    private static ForumPostDAO fpdi = new ForumPostDAOImpl();

    public ForumPostDAO getFpdi() {
        return fpdi;
    }

    private static class AddPostServiceHolder {
        private static final AddPostService INSTANCE = new AddPostService();
    }

    public static final AddPostService getInstance() {
        return AddPostServiceHolder.INSTANCE;
    }

    public int addPostWithMsg(ForumPost post, int t_uid, String subject) {
        int posi = AddPostServiceHolder.INSTANCE.getFpdi().addPost(post);
        if (posi != 0) {
            ForumMessage fmsg = new ForumMessage(post.getAuthor(), post.getAuthorUid(), t_uid, subject, post.getDateline().getTime(), 1, post.getFid(), post.getTid());
            fmsg.setPosition(posi);
            if (new ForumMessageDAOImpl().addMsg(1, fmsg)) {
                return posi;
            }
        }
        return 0;
    }

    public int addPost(ForumPost post, int t_uid, String subject) {
        int posi = AddPostServiceHolder.INSTANCE.getFpdi().addPost(post);
        if (posi != 0) {
            return posi;
        } else {
            return 0;
        }
    }
}
