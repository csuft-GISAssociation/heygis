package com.heygis.service;

import java.text.SimpleDateFormat;

import com.heygis.constants.ForumConstant;
import com.heygis.dao.interfaces.ForumPostDAO;
import com.heygis.service.interfaces.ForumsThreadService;
import org.json.JSONArray;
import org.json.JSONObject;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;
import com.heygis.dao.interfaces.ForumThreadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumsThreadServiceImpl implements ForumsThreadService {

    @Autowired
    private ForumThreadDAO forumThreadDAO;
    @Autowired
    private ForumPostDAO forumPostDAO;

    public ForumsThreadPage getThreadPage(int fid, int page) {
        ForumsThreadPage threadPage = forumThreadDAO.getThreadPageByFid(fid, page);
        int threadCountThisFid = forumThreadDAO.getThreadCountByFid(fid);
        threadPage.setTotalThreadNum(threadCountThisFid);
        return threadPage;
    }

    public boolean addthread(ForumThread thread, ForumPost post) {
        //先插入thread 成功再插入post
        int tid = forumThreadDAO.addThread(thread, post);
        if (tid != ForumConstant.WRONG_TID) {
            post.setTid(tid);
            int pid = forumPostDAO.addPost(post);
            if (pid != ForumConstant.WRONG_PID)
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public String getMyThread(int uid, int page) {
        ForumsThreadPage threadPage = forumThreadDAO.getThreadPageByUid(uid, page);
        JSONObject tl = new JSONObject();
        JSONArray threadArray = new JSONArray();
        try {
            tl.put("size", threadPage.getSize());
            tl.put("page", threadPage.getPage());
            JSONObject thread;
            for (int i = 0; i < threadPage.getSize(); i++) {
                thread = new JSONObject();
                thread.put("tid", threadPage.getThread(i).getTid());
                thread.put("subject", threadPage.getThread(i).getSubject());
                thread.put("dateline", new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(threadPage.getThread(i).getDateline()));
                thread.put("lastpost", threadPage.getThread(i).getLastpost());
                thread.put("lastposter", threadPage.getThread(i).getLastposter());
                thread.put("views", threadPage.getThread(i).getViews());
                thread.put("replies", threadPage.getThread(i).getReplies());
                thread.put("close", threadPage.getThread(i).getClose());
                thread.put("displayorer", threadPage.getThread(i).getDisplayorer());
                threadArray.put(thread);
            }
            tl.put("threadArray", threadArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tl.toString();
    }
}
