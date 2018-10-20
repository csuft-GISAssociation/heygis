package com.heygis.service;

import com.heygis.common.exception.ForumException;
import com.heygis.constants.ForumConstant;
import com.heygis.dao.interfaces.ForumThreadDAO;
import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dao.interfaces.ForumMessageDAO;
import com.heygis.dao.interfaces.ForumPostDAO;
import com.heygis.dto.ForumPostPage;
import com.heygis.service.interfaces.ForumsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ForumsPostServiceImpl implements ForumsPostService {

    @Autowired
    private ForumPostDAO forumPostDAO;

    @Autowired
    private ForumThreadDAO forumThreadDAO;

    @Autowired
    private ForumMessageDAO forumMessageDAO;

    public int addPost(ForumPost post, int t_uid) {
        int posi = ForumConstant.WRONG_POSI;
        if (post.getAuthorUid() != t_uid) {
            //作者 和 楼主 不是一人，楼主会有新回复消息
            posi = addPostWithMsg(post, t_uid);
        } else {
            //作者 和 楼主 是一个人，不用添加新消息
            posi = addPostWithoutMsg(post);
        }
        //更新该post位于的thread
        if (posi != ForumConstant.WRONG_POSI) {
            if(forumThreadDAO.updateThreadLastPost(post)){
                return posi;
            }
        }
        return ForumConstant.WRONG_POSI;
    }

    /**
     * 添加带新消息的新帖子
     * @param post
     * @param t_uid 帖子作者uid，被通知的对象
     * @return
     */
    private int addPostWithMsg(ForumPost post, int t_uid) {
        int posi = forumPostDAO.addPost(post);
        if (posi != ForumConstant.WRONG_POSI) {
            ForumMessage fmsg = new ForumMessage(post.getAuthor(), post.getAuthorUid(), t_uid, post.getSubject(), post.getDateline().getTime(), 1, post.getFid(), post.getTid());
            fmsg.setPosition(posi);
            if (forumMessageDAO.addMsg(1, fmsg)) {
                return posi;
            }
        }
        return ForumConstant.WRONG_POSI;
    }

    /**
     * 添加不带新消息的新帖子
     * @param post
     * @return
     */
    private int addPostWithoutMsg(ForumPost post) {
        int posi = forumPostDAO.addPost(post);
        if (posi != ForumConstant.WRONG_POSI) {
            return posi;
        } else {
            return ForumConstant.WRONG_POSI;
        }
    }

    public String getPostMessage(int pid) {
        return forumPostDAO.getPostMessage(pid);
    }

    public boolean addReplyPost(ForumPost post, ForumMessage fmsg, int t_uid, int author_uid) {
        //先发帖
        int replyposi = addPost(post, t_uid);
        if (replyposi != ForumConstant.WRONG_POSI) {
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

    public ForumPostPage getPostPage(int tid, int pageNum) {
        ForumPostPage forumPostPage = forumPostDAO.getPostPage(tid, pageNum);
        //注：原本post 内容的 回复引用格式是在存入前构造好，存入的是构造好的html
        //此处改为 回复引用格式每次根据 is_reply,be_reply_posi字段动态构造
        forumPostPage = reStructurePage(forumPostPage);
        return forumPostPage;
    }

    /**
     * 把forumPostPage中所有的 是回复的 post内容(message) ，构造成在前端显示为引用格式的内容文本；有问题的话问yrc
     * @param forumPostPage
     * @return
     */
    private ForumPostPage reStructurePage(ForumPostPage forumPostPage){
        //循环page里的每一个post，如果是回复的post，则构造其message
        for (ForumPost post : forumPostPage.getPostList()) {
            if (post.isReplyPost()) {
                //用于存放整个回复关系链条上的每个回复
                LinkedList<ForumPost> replyPostList = new LinkedList<>();
                ForumPost beReplyedPost = post;
                //循环到 最早被恢复的那个帖子 或 上一个已经被构造过的（被构造过就可以在此基础上构造，不太用从头构造）
                while (beReplyedPost.isReplyPost() && !beReplyedPost.isReplayStructured()) {
                    //循环把回复链上的post依次加入到replyPostList中
                    replyPostList.add(beReplyedPost);
                    try {
                        beReplyedPost = getPostByPosi(forumPostPage, beReplyedPost.getBeReplyPosi());
                        //被删除的情况
                        if(beReplyedPost.isDeleted())
                            beReplyedPost = new ForumPost("未知",new Date(),"该贴被删除", beReplyedPost.getBeReplyPosi(),0);
                    } catch (ForumException e) {
                        //未找到的情况
                        beReplyedPost = new ForumPost("未知",new Date(),"该贴未找到", beReplyedPost.getBeReplyPosi(),0);
                    }
                }
                //把最上面那个最初被回复的也加入list
                replyPostList.add(beReplyedPost);
                //重新填充message，以及吧被构造的标签置为true
                String newMsg = structureReplayMsg(replyPostList);
                post.setMessage(newMsg);
                post.setReplayStructured(true);
            }
        }
        return forumPostPage;
    }

    /**
     * 根据posi在该page找post，不在该page则往前找，page构成链条
     * 逻辑暂时比较粗糙，有空后面优化
     * @param page
     * @param posi
     * @return
     * @throws ForumException
     */
    private ForumPost getPostByPosi(ForumPostPage page, int posi) throws ForumException {
        List<ForumPost> postsInThisPage = page.getPostList();
        //小于该page最小的posi，说明不在此page
        if (posi < postsInThisPage.get(0).getPosition()) {
            int pageNum = page.getPageNum();
            if (pageNum <= 1)
                throw new ForumException("未找到该帖子");
            //获取前一页page
            ForumPostPage prePage = page.getPrePage();
            if(prePage == null){
                //获取前一页postPage并通过prePage关联起来
                prePage = forumPostDAO.getPostPage(page.getTid(), pageNum - 1);
                page.setPrePage(prePage);
            }
            return getPostByPosi(prePage,posi);
        }
        //在此page的情况下，在page中寻找该post
        int lastPosi = postsInThisPage.get(postsInThisPage.size() - 1).getPosition();
        //根据posi的差在数组中定位到该post
        int index = postsInThisPage.size() - (lastPosi - posi);
        if (postsInThisPage.get(index).getPosition() == posi)
            return postsInThisPage.get(index);
        while (postsInThisPage.get(index).getPosition() < posi){
            index++;
            if (postsInThisPage.get(index).getPosition() == posi)
                return postsInThisPage.get(index);
            if (postsInThisPage.get(index).getPosition() > posi)
                throw new ForumException("未找到该帖子");
        }
        while (postsInThisPage.get(index).getPosition() > posi){
            index--;
            if (postsInThisPage.get(index).getPosition() == posi)
                return postsInThisPage.get(index);
            if (postsInThisPage.get(index).getPosition() < posi)
                throw new ForumException("未找到该帖子");
        }
        //走到这里还没找到帖子，报错
        throw new ForumException("未找到该帖子");
    }

    /**
     * 根据replyPostList构造msg
     * @param replyPostList
     * @return
     */
    private String structureReplayMsg(List<ForumPost> replyPostList) {
        StringBuilder msg = new StringBuilder();
        //把这个post从list里取出来；
        ForumPost thisPost = replyPostList.remove(0);
        for (int i = replyPostList.size() - 1; i >= 0; i--) {
            ForumPost post = replyPostList.get(i);
            msg.insert(0,"<fieldset><legend>回复:" + post.getPosition() + "楼" + post.getAuthor() + "</legend><blockquote>");
            msg.append(post.getMessage());
            msg.append("</blockquote></fieldset>");
        }
        return msg.append(thisPost.getMessage()).toString();
    }
}
