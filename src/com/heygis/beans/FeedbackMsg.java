package com.heygis.beans;

import java.util.Date;

public class FeedbackMsg {
	private String account;
	private String nickname;
	private String time;
	private String feedbackContent;
	private String accountImg;
	public FeedbackMsg(){
		
	}
	public FeedbackMsg(String account,String nickname,String time,String feedbackContent,String accountImg){
		this.account = account;
		this.nickname = nickname;
		this.time = time;
		this.feedbackContent = feedbackContent;
		this.accountImg = accountImg;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public String getAccountImg() {
		return accountImg;
	}
	public void setAccountImg(String accountImg) {
		this.accountImg = accountImg;
	}
	
}
