package com.heygis.service;

import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dao.ForumMessageDAOImpl;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.interfaces.ForumMessageDAO;
import com.heygis.dao.interfaces.ForumPostDAO;

public class ReplyPostService {
	private ForumPostDAO postDAO = null;
	private ForumMessageDAO msgDAO= null;
	
	public ReplyPostService(){
		postDAO = new ForumPostDAOImpl();
		msgDAO = new ForumMessageDAOImpl();
	}
	public String getPostMessage(int pid){
		return postDAO.getPostMessage(pid);
	}
	public boolean addReplyPost(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = 0;
		if(author_uid != t_uid){
			replyposi = aps.addPostWithMsg(post, t_uid, fmsg.getSubject());
		}else{
			replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		}
		if(replyposi != 0){
			if(author_uid != fmsg.getRd_uid()){
				fmsg.setPosition(replyposi);
				if(msgDAO.addMsg(2, fmsg)){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}
		return false;
	}
	//111
	public boolean addReplyPost1(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			return true;
		}
		return false;
	}
	//112 & 121
	public boolean addReplyPost2(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPost(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			fmsg.setPosition(replyposi);
			if(msgDAO.addMsg(2, fmsg)){
				return true;
			}
		}
		return false;
	}
	//211
	public boolean addReplyPost4(ForumPost post, ForumMessage fmsg,int t_uid,int author_uid){
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.addPostWithMsg(post, t_uid, fmsg.getSubject());
		if(replyposi != 0){
			fmsg.setPosition(replyposi);
			if(msgDAO.addMsg(2, fmsg)){
				return true;
			}
		}
		return false;
	}
}
