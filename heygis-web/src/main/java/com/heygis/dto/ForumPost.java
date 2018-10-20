package com.heygis.dto;

import java.util.Date;

public class ForumPost {
    private int pid;
    private int fid;
    private int tid;
    private int first;
    private String author;
    private int authorUid;
    private String authorAccount;
    private String subject;
    private Date dateline;
    private String message;
    private String userip;
    private int attchment;
    private int position;
    private String icon;
    //是否是回帖，0为否，1为是
    private int isReplyPost;
    private int beReplyUid;
    private int beReplyPosi;
    //true表示该post的msg已经被构造过回复引用了
    private boolean replayStructured;
    private int deleted;

    public ForumPost(int pid, int fid, int tid, int first, String author, int authorUid, String authorAccount,
                     String subject, Date dateline, String message, String userip, int attchment, int position,
                     String icon, int isReplyPost, int beReplyUid, int beReplyPosi, int deleted) {
        this.pid = pid;
        this.fid = fid;
        this.tid = tid;
        this.first = first;
        this.author = author;
        this.authorUid = authorUid;
        this.authorAccount = authorAccount;
        this.subject = subject;
        this.dateline = dateline;
        this.message = message;
        this.userip = userip;
        this.attchment = attchment;
        this.position = position;
        this.icon = icon;
        this.isReplyPost = isReplyPost;
        this.beReplyUid = beReplyUid;
        this.beReplyPosi = beReplyPosi;
        this.deleted = deleted;
    }

    public ForumPost(int pid, int fid, int tid, int first, String author,
                     int authorUid, String authorAccount, String subject, Date dateline,
                     String message, String userip, int attchment, int isReplyPost) {
        super();
        this.pid = pid;
        this.fid = fid;
        this.tid = tid;
        this.first = first;
        this.author = author;
        this.authorUid = authorUid;
        this.authorAccount = authorAccount;
        this.subject = subject;
        this.dateline = dateline;
        this.message = message;
        this.userip = userip;
        this.attchment = attchment;
        this.isReplyPost = isReplyPost;
    }

    public ForumPost(int pid, int fid, int tid, int first, String author, int authorUid,
                     String authorAccount, String subject, Date dateline, String message,
                     String userip, int attchment, int isReplyPost, int beReplyUid,
                     int beReplyPosi) {
        super();
        this.pid = pid;
        this.fid = fid;
        this.tid = tid;
        this.first = first;
        this.author = author;
        this.authorUid = authorUid;
        this.authorAccount = authorAccount;
        this.subject = subject;
        this.dateline = dateline;
        this.message = message;
        this.userip = userip;
        this.attchment = attchment;
        this.position = position;
        this.isReplyPost = isReplyPost;
        this.beReplyUid = beReplyUid;
        this.beReplyPosi = beReplyPosi;
    }

    public ForumPost(String author, Date dateline, String message, int position, int isReplyPost) {
        this.author = author;
        this.dateline = dateline;
        this.message = message;
        this.position = position;
        this.isReplyPost = isReplyPost;
    }

    public int getAuthorUid() {
        return authorUid;
    }

    public void setAuthorUid(int authorUid) {
        this.authorUid = authorUid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorAccount() {
        return authorAccount;
    }

    public void setAuthorAccount(String authorAccount) {
        this.authorAccount = authorAccount;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public int getAttchment() {
        return attchment;
    }

    public void setAttchment(int attchment) {
        this.attchment = attchment;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public int getIsReplyPost() {
        return isReplyPost;
    }

    public boolean isReplyPost() {
        return isReplyPost == 1;
    }

    public int getBeReplyUid() {
        return beReplyUid;
    }

    public int getBeReplyPosi() {
        return beReplyPosi;
    }

    public boolean isReplayStructured() {
        return replayStructured;
    }

    public void setReplayStructured(boolean replayStructured) {
        this.replayStructured = replayStructured;
    }

    public boolean isDeleted() {
        return deleted == 1;
    }

}
