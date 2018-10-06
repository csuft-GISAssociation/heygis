package com.heygis.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.heygis.service.interfaces.NewMsgService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.heygis.dto.ForumMsgPage;
import com.heygis.dao.interfaces.ForumMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewMsgServiceImpl implements NewMsgService {

    @Autowired
    ForumMessageDAO fMsgDAO;

    public int howManyNewMsg(int uid) {
        return fMsgDAO.howManyNewMsg(uid);
    }

    public int howManyOldwMsg(int uid) {
        return fMsgDAO.howManyOldMsg(uid);
    }

    public ForumMsgPage getMsgPage(int uid, int page, int n) {
        return fMsgDAO.getMsgPage(uid, page, n);
    }

    public String getMsgList(int uid, int page, int n) {
        ForumMsgPage msgPage = fMsgDAO.getMsgPage(uid, page, n);
        JSONObject mp = new JSONObject();
        JSONArray msgArray = new JSONArray();
        try {
            mp.put("size", msgPage.getSize());
            mp.put("page", msgPage.getPage());
            JSONObject msg;
            for (int i = 0; i < msgPage.getSize(); i++) {
                msg = new JSONObject();
                msg.put("mid", msgPage.getMsg(i).getMid());
                msg.put("author", msgPage.getMsg(i).getAuthor());
                msg.put("rd_uid", msgPage.getMsg(i).getRd_uid());
                msg.put("subject", msgPage.getMsg(i).getSubject());
                msg.put("dateline", new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date(msgPage.getMsg(i).getDateline())));
                msg.put("type", msgPage.getMsg(i).getType());
                msg.put("fid", msgPage.getMsg(i).getFid());
                msg.put("tid", msgPage.getMsg(i).getTid());
                msg.put("position", msgPage.getMsg(i).getPosition());
                msg.put("page", msgPage.getMsg(i).getPage());
                msgArray.put(msg);
            }
            mp.put("msgArray", msgArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mp.toString();
    }

    public boolean makeMsgOld(int mid) {
        return fMsgDAO.makeMsgOld(mid);
    }
}
