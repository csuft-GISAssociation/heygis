package com.heygis.dto;

public class ForumPostPage {
	private int fid;
	private int tid;
	private int page;
	private int fPage;
	private int beginPosi;
	private int endPosi;
//	private int totalPage;
	private int post_number;
	private int size;
	private int totalPostNum;
	private int totalPageNum;
	private ForumPost[] postArray;
	
	public ForumPostPage(int tid,int page) {
		this.tid = tid;
		this.page = page;
		beginPosi = page * 30 + -29;
		endPosi = page * 30;
		postArray = new ForumPost[30];
		post_number = 0;
		size = 0;
	}
//	public int getPost_number() {
//		return post_number;
//	}
//	public void setPost_number(int post_number) {
//		this.post_number = post_number;
//	}
//	public int getTotalPage() {
//		return totalPage;
//	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
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
		post_number = i;
		size++;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getfPage() {
		return fPage;
	}
	public void setfPage(int fPage) {
		this.fPage = fPage;
	}
	public int getSize() {
		return size;
	}
	public int getTotalPostNum() {
		return totalPostNum;
	}
	public void setTotalPostNum(int totalPostNum) {
		this.totalPostNum = totalPostNum;
		if(totalPostNum%30==0){
			totalPageNum = totalPostNum/30;
		}else{
			totalPageNum = totalPostNum/30 + 1;
		}
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
}
