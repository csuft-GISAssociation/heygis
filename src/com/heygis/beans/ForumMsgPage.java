package com.heygis.beans;

public class ForumMsgPage {
	private int size;
	private int uid;
	private int page;
	private int msg_number;
	private ForumMessage[] msgArray;
	
	public ForumMsgPage(int uid, int page) {
		this.uid = uid;
		this.page = page;
		this.size = 0;
		this.msg_number = 0;
		this.msgArray = new ForumMessage[20];
	}
	public int getPage() {
		return page;
	}
	public void addMsg(ForumMessage m){
		msgArray[size] = m;
		size++;
	}
	public ForumMessage getMsg(int i){
		return msgArray[i];
	}

	public int getSize() {
		return size;
	}
	public void setMsg_number(int msg_number) {
		this.msg_number = msg_number;
	}
}
