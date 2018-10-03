package com.heygis.service;

import com.heygis.dao.ForumThreadDAOImpl;
import com.heygis.dao.interfaces.ForumThreadDAO;
import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dao.ForumMessageDAOImpl;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumMessageDAO;
import com.heygis.dao.interfaces.ForumPostDAO;
import com.heygis.dto.ForumPostPage;

public class ForumsPostService {
    private ForumPostDAO forumPostDAO = null;
    private ForumThreadDAO forumThreadDAO = null;
    private ForumMessageDAO forumMessageDAO = null;

    private static final int POST_WRONG_POSI = -1;

    public ForumsPostService() {
        forumPostDAO = new ForumPostDAOImpl();
        forumThreadDAO = new ForumThreadDAOImpl();
        forumMessageDAO = new ForumMessageDAOImpl();
    }

    public int addPost(ForumPost post, int t_uid) {
        int posi = POST_WRONG_POSI;
        if (post.getAuthorUid() != t_uid) {
            //作者 和 楼主 不是一人，楼主会有新回复消息
            posi = addPostWithMsg(post, t_uid);
        } else {
            //作者 和 楼主 是一个人，不用添加新消息
            posi = addPostWithoutMsg(post);
        }
        //更新该post位于的thread
        if (posi != POST_WRONG_POSI) {
            if(forumThreadDAO.updateThreadLastPost(post)){
                return posi;
            }
        }
        return POST_WRONG_POSI;
    }

    /**
     * 添加带新消息的新帖子
     *
     * @param post
     * @param t_uid 帖子作者uid，被通知的对象
     * @return
     */
    private int addPostWithMsg(ForumPost post, int t_uid) {
        int posi = forumPostDAO.addPost(post);
        if (posi != POST_WRONG_POSI) {
            ForumMessage fmsg = new ForumMessage(post.getAuthor(), post.getAuthorUid(), t_uid, post.getSubject(), post.getDateline().getTime(), 1, post.getFid(), post.getTid());
            fmsg.setPosition(posi);
            if (forumMessageDAO.addMsg(1, fmsg)) {
                return posi;
            }
        }
        return POST_WRONG_POSI;
    }

    /**
     * 添加不带新消息的新帖子
     *
     * @param post
     * @return
     */
    private int addPostWithoutMsg(ForumPost post) {
        int posi = forumPostDAO.addPost(post);
        if (posi != POST_WRONG_POSI) {
            return posi;
        } else {
            return POST_WRONG_POSI;
        }
    }

    /**
     * 根据pid获取post的内容
     *
     * @param pid
     * @return
     */
    public String getPostMessage(int pid) {
        return forumPostDAO.getPostMessage(pid);
    }

    /**
     * 添加帖子回复
     *
     * @param post
     * @param fmsg
     * @param t_uid
     * @param author_uid
     * @return
     */
    public boolean addReplyPost(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid) {
        //先发帖
        int replyposi = addPost(post, t_uid);
        if (replyposi != POST_WRONG_POSI) {
            //作者 和 被回复者 不是一个人，被回复者会有新回复消息
            if (author_uid != fmsg.getRd_uid()) {
                fmsg.setPosition(replyposi);
                if (forumMessageDAO.addMsg(2, fmsg)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                //作者 和 被回复者 是一个人，不用添加新消息
                return true;
            }
        }
        return false;
    }

    /**
     * 按page获取一页的帖子话题topic
     *
     * @param tid
     * @param page
     * @return
     */
    public ForumPostPage getPostPage(int tid, int page) {
        return forumPostDAO.getPostPage(tid, page);
    }

//    废弃代码，不用管
//    //111
//    public boolean addReplyPost1(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid) {
//        AddPostService aps = AddPostService.getInstance();
//        int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
//        if (replyposi != 0) {
//            return true;
//        }
//        return false;
//    }
//
//    //112 & 121
//    public boolean addReplyPost2(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid) {
//        AddPostService aps = AddPostService.getInstance();
//        int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
//        if (replyposi != 0) {
//            fmsg.setPosition(replyposi);
//            if (forumMessageDAO.addMsg(2, fmsg)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //211
//    public boolean addReplyPost4(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid) {
//        AddPostService aps = AddPostService.getInstance();
//        int replyposi = aps.addPostWithMsg(post, t_uid, fmsg.getSubject());
//        if (replyposi != 0) {
//            fmsg.setPosition(replyposi);
//            if (forumMessageDAO.addMsg(2, fmsg)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
