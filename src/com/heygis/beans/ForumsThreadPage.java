package com.heygis.beans;

public class ForumsThreadPage {
	private int page;
	private int beginPosi;
	private int endPosi;
	private int totalPage;
	private ForumThread[] threadArray;
	
	public ForumsThreadPage(int page) {
		this.page = page;
		beginPosi = page * 10 + 1;
		endPosi = beginPosi + 29;
		threadArray = new ForumThread[30];
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public ForumThread[] getThreadArray() {
		return threadArray;
	}
	public void addThread(int i, ForumThread thread) {
		this.threadArray[i]= thread;
	}
	public ForumThread getThread(int i) {
		return threadArray[i];
	}
}
