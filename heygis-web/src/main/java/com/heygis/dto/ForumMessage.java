package com.heygis.dto;

public class ForumMessage {
	int mid;
	String author;
	int rd_uid;
	String subject;
	long dateline;
	int type;
	int fid;
	int tid;
	int position;
	int page;
	
	public ForumMessage(String author, int rd_uid, String subject,
			long dateline, int type, int fid, int tid) {
		super();
		this.author = author;
		this.rd_uid = rd_uid;
		this.subject = subject;
		this.dateline = dateline;
		this.type = type;
		this.fid = fid;
		this.tid = tid;
	}
	public ForumMessage(int mid, String author, int rd_uid, String subject,
			long dateline, int type, int fid, int tid, int position) {
		super();
		this.mid = mid;
		this.author = author;
		this.rd_uid = rd_uid;
		this.subject = subject;
		this.dateline = dateline;
		this.type = type;
		this.fid = fid;
		this.tid = tid;
		this.position = position;
		if(position%30==0){
			page = position/30;
		}else{
			page = position/30 + 1;
		}
	}
	public String getAuthor() {
		return author;
	}
	public int getRd_uid() {
		return rd_uid;
	}
	public String getSubject() {
		return subject;
	}
	public long getDateline() {
		return dateline;
	}
	public int getType() {
		return type;
	}
	public int getFid() {
		return fid;
	}
	public int getTid() {
		return tid;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getPage() {
		return page;
	}
	public int getMid() {
		return mid;
	}
	
}
