package com.heygis.beans;

public class ForumPostPage {
	private int tid;
	private int page;
	private int beginPosi;
	private int endPosi;
	private int totalPage;
	private ForumPost[] postArray;
	
	public ForumPostPage(int tid,int page) {
		this.tid = tid;
		this.page = page;
		beginPosi = page * 30 + -29;
		endPosi = page * 30;
		postArray = new ForumPost[30];
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setPostArray(ForumPost[] postArray) {
		this.postArray = postArray;
	}
	public int getBeginPosi() {
		return beginPosi;
	}
	public int getEndPosi() {
		return endPosi;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public ForumPost getPost(int i) {
		return this.postArray[i];
	}
	public void setPost(int i,ForumPost post) {
		this.postArray[i] = post;
	}
}
