package com.heygis.dto;

import java.util.ArrayList;
import java.util.List;

public class ForumPostPage {
    private int fid;
    private int tid;
    //当前页码
    private int pageNum;
    //fPage指在板块的哪一页
    private int fPageNum;
    private List<ForumPost> postList;
    private ForumPostPage prePage;

    //该tid下post数量
    private int totalPostNum;
    //该tid下page数量
    private int totalPageNum;

    public ForumPostPage(int tid, int pageNum) {
        this.tid = tid;
        this.pageNum = pageNum;
        postList = new ArrayList<>();
    }

    public int getPageNum() {
        return pageNum;
    }

    public ForumPost getPost(int i) {
        if (i > postList.size() - 1)
            return null;
        return this.postList.get(i);
    }

    public void setPost(int i, ForumPost post) {
        this.postList.add(post);
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

    public int getfPageNum() {
        return fPageNum;
    }

    public void setfPageNum(int fPageNum) {
        this.fPageNum = fPageNum;
    }

    public int getSize() {
        return postList.size();
    }

    public int getTotalPostNum() {
        return totalPostNum;
    }

    public void setTotalPostNum(int totalPostNum) {
        this.totalPostNum = totalPostNum;
        if (totalPostNum % 30 == 0) {
            totalPageNum = totalPostNum / 30;
        } else {
            totalPageNum = totalPostNum / 30 + 1;
        }
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public List<ForumPost> getPostList() {
        return postList;
    }

    public ForumPostPage getPrePage() {
        return prePage;
    }

    public void setPrePage(ForumPostPage prePage) {
        this.prePage = prePage;
    }
}
