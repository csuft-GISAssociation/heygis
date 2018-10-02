package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumPostPage;
import com.heygis.dao.interfaces.ForumPostDAO;

public class ForumPostDAOImpl extends DAOSupport implements ForumPostDAO {

    /**
     * 老版本实现，废弃
     *
     * @param post
     * @return
     */
    public synchronized int addPostOld(ForumPost post) {
        //pid楼层是帖子内自增，一张表内会有很多12345...
        //为避免多线程不安全，用同步方法，楼层数每次统计
        String countPidSql = "select count(pid) from forum_post;";
        this.openConn();
        ResultSet rs = this.execQuery(countPidSql);
        int pid = 0;
        try {
            if (rs.next())
                pid = rs.getInt(1) + 1;
//			System.out.println("pid="+pid);
            String addPostSql = "insert into forum_post (pid,fid,tid,first,author,author_uid,author_account"
                    + ",subject,dateline,message,userip,attachment) values (?,?,?,?,?,?,?,?,?,?,?,?);";
            if (this.execUpdate(addPostSql, pid, post.getFid(), post.getTid(), post.getFirst(), post.getAuthor(),
                    post.getAuthorUid(), post.getAuthorAccount(), post.getSubject(), new Date().getTime(), post.getMessage(),
                    post.getUserip(), post.getAttchment()) == 1) {
                String updateThreadSql = "update forum_thread SET lastpost=? ,lastposter=? ,replies=replies+1 where tid=?;";
                this.execUpdate(updateThreadSql, new Date().getTime(), post.getAuthor(), post.getTid());
                int posi = this.LAST_INSERT_ID();
                this.close();
                return posi;
            } else {
                this.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (!this.conn.isClosed())
                    this.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int addPost(ForumPost post) {
        try {
            this.openConn();
            String addPostSql = "insert into forum_post (pid,fid,tid,first,author,author_uid,author_account,subject,dateline,message,userip,attachment,is_reply_post,be_reply_uid,be_reply_posi)  "
                    + "select max(pid+1),?,?,?,?,?,?,?,?,?,?,?,?,?,? from forum_post;";
            //测试表 pid为自增字段 的sql
//            String addPostSql = "insert into test_forum_post (fid,tid,first,author,author_uid,author_account,subject,dateline,message,userip,attachment,is_reply_post,be_reply_uid,be_reply_posi,position)  "
//                    + "select ?,?,?,?,?,?,?,?,?,?,?,?,?,?,count(position)+1 from test_forum_post where tid = ?;";
            int exeNum = this.execUpdate(addPostSql, post.getFid(), post.getTid(), post.getFirst(), post.getAuthor(),
                    post.getAuthorUid(), post.getAuthorAccount(), post.getSubject(), new Date().getTime(), post.getMessage(),
                    post.getUserip(), post.getAttchment(), post.getIsReplyPost(), post.getBeReplyUid(), post.getBeReplyPosi());
            if (exeNum == 1) {
                int posi = this.LAST_INSERT_ID();
                return posi;
            } else {
                this.close();
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            this.close();
        }
    }

    public boolean delPost(int pid) {
        String sql = "update forum_post set message=? where pid=?;";
        this.openConn();
        if (this.execUpdate(sql, "此楼被删除", pid) == 1) {
            this.close();
            return true;
        } else {
            this.close();
            return false;
        }
    }

    //有三个sql，属于论坛业务逻辑，应该写在Service层里的，后面再拆吧
    @SuppressWarnings("finally")
    public ForumPostPage getPostPage(int tid, int page) {
        try {
            this.openConn();
            //获取分页内容
            int begin = (page - 1) * 30;
            int end = 30;
            String selectPageSql = "select forum_post.*,users_info.nickname,users_info.icon_img "
                    + "from forum_post,users_info "
                    + "where forum_post.author_uid=users_info.uid and tid =? limit ?,?;";

            ForumPostPage postPage = new ForumPostPage(tid, page);
            ResultSet rs = this.execQuery(selectPageSql, tid, begin, end);
            postPage.setTid(tid);
            int i = 0;
            while (rs.next()) {
                postPage.setPost(i, new ForumPost(
                        rs.getInt("pid"),
                        rs.getInt("fid"),
                        rs.getInt("tid"),
                        rs.getInt("first"),
                        rs.getString("nickname"),
                        rs.getInt("author_uid"),
                        rs.getString("author_account"),
                        rs.getString("subject"),
                        new Date(rs.getLong("dateline")),
                        rs.getString("message"),
                        rs.getString("userip"),
                        rs.getInt("attachment"),
                        rs.getInt("position"),
                        rs.getString("icon_img")));
                i++;
            }
            //查询帖子总楼层数
            ResultSet count = this.execQuery("select count(*) from forum_post where tid =?", tid);
            while (count.next()) {
                postPage.setTotalPostNum(count.getInt(1));
            }
            //更新帖子浏览数
            String updatViewSql = "update forum_thread SET views=views+1 where tid=?;";
            this.execUpdate(updatViewSql, tid);
            return postPage;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

    public String getPostMessage(int pid) {
        String sql = "select message from forum_post where pid = ?";
        this.openConn();
        ResultSet rs = this.execQuery(sql, pid);
        String message = null;
        try {
            while (rs.next()) {
                message = rs.getString("message");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return message;
    }

}
