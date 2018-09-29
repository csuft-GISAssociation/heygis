package com.heygis.dto;

public class ForumsThreadPage {
	private int fid;
	private int page;
	private int beginPosi;
	private int endPosi;
	private int thread_number;
	private int size;
	private int totalThreadNum;
	private int totalPageNum;
	private ForumThread[] threadArray;
	
	public ForumsThreadPage(int fid, int page) {
		this.fid = fid;
		this.page = page;
		beginPosi = page * 10 + 1;
		endPosi = beginPosi + 29;
		threadArray = new ForumThread[30];
		thread_number = 0;
		size=0;
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
	public void setThread(int i, ForumThread thread) {
		this.threadArray[i]= thread;
		thread_number = i;
		size++;
	}
//	public int getThread_number() {
//		return thread_number;
//	}
//	public void setThread_number(int thread_number) {
//		this.thread_number = thread_number;
//	}
	public ForumThread getThread(int i) {
		return threadArray[i];
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getSize() {
		return size;
	}
	public int getTotalThreadNum() {
		return totalThreadNum;
	}
	public void setTotalThreadNum(int totalThreadNum) {
		this.totalThreadNum = totalThreadNum;
		if(totalThreadNum%30==0){
			totalPageNum = totalThreadNum/30;
		}else{
			totalPageNum = totalThreadNum/30 + 1;
		}
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
}
