package com.heygis.beans;

import java.util.Date;

public class User {
	private String account;
	private String passWord;
	private String nickName;
	private String gender;
	private String grade;
	private String QQ;
	private String tel;
	private String selfIntroduction;
	private int identityId = 3;
	private String iconImg;
	
	public User(String account,String passWord,String nickName,String grade,String gender,String QQ,String tel,String selfIntroduction,String iconImg){
		this.account = account;
		this.passWord = passWord;
		this.nickName = nickName;
		this.grade = grade;
		this.gender = gender;
		this.QQ = QQ;
		this.tel = tel;
		this.selfIntroduction = selfIntroduction;
		this.iconImg = iconImg;
	}
	public User(String account,String nickName,String grade,String gender,String QQ,String tel,String selfIntroduction,String iconImg){
		this.account = account;
		this.nickName = nickName;
		this.grade = grade;
		this.gender = gender;
		this.QQ = QQ;
		this.tel = tel;
		this.selfIntroduction = selfIntroduction;
		this.iconImg = iconImg;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	public String getIconImg() {
		return iconImg;
	}
	public void setIconImg(String iconImg) {
		this.iconImg = iconImg;
	}
	
}
