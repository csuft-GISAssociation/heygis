package com.heygis.beans;

public class ForumPostPage {
	private int page;
	private ForumPost[] postArray;
	
	public ForumPostPage(int page) {
		this.page = page;
		postArray = new ForumPost[30];
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public ForumPost[] getPostArray() {
		return postArray;
	}
	public void addThread(int i,ForumPost post) {
		this.postArray[i] = post;
	}
	public ForumPost getPost(int i) {
		return postArray[i];
	}
}
