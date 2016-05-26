package com.heygis.beans;

import java.util.Date;

public class ForumThread {
	private int tid;
	private int fid;
	private int typeid;
	private int sortid;
	private String author;
	private int authorUid;
	private String authorAuthor;
	private String subject;
	private Date dateline;
	private Date lastpost;
	private String lastposter;
	private int views;
	private int replies;
	private int attachment;
	private int close;
	private int status;
	private int displayorer;
	public ForumThread(int tid, int fid, int typeid, int sortid, String author,
			int authorUid, String authorAuthor, String subject, Date dateline,
			Date lastpost, String lastposter, int views, int replies,
			int attachment, int close, int status, int displayorer) {
		super();
		this.tid = tid;
		this.fid = fid;
		this.typeid = typeid;
		this.sortid = sortid;
		this.author = author;
		this.authorUid = authorUid;
		this.authorAuthor = authorAuthor;
		this.subject = subject;
		this.dateline = dateline;
		this.lastpost = lastpost;
		this.lastposter = lastposter;
		this.views = views;
		this.replies = replies;
		this.attachment = attachment;
		this.close = close;
		this.status = status;
		this.displayorer = displayorer;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAuthorUid() {
		return authorUid;
	}
	public void setAuthorUid(int authorUid) {
		this.authorUid = authorUid;
	}
	public String getAuthorAuthor() {
		return authorAuthor;
	}
	public void setAuthorAuthor(String authorAuthor) {
		this.authorAuthor = authorAuthor;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDateline() {
		return dateline;
	}
	public void setDateline(Date dateline) {
		this.dateline = dateline;
	}
	public Date getLastpost() {
		return lastpost;
	}
	public void setLastpost(Date lastpost) {
		this.lastpost = lastpost;
	}
	public String getLastposter() {
		return lastposter;
	}
	public void setLastposter(String lastposter) {
		this.lastposter = lastposter;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	public int getAttachment() {
		return attachment;
	}
	public void setAttachment(int attachment) {
		this.attachment = attachment;
	}
	public int getClose() {
		return close;
	}
	public void setClose(int close) {
		this.close = close;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDisplayorer() {
		return displayorer;
	}
	public void setDisplayorer(int displayorer) {
		this.displayorer = displayorer;
	}
	
	
}
