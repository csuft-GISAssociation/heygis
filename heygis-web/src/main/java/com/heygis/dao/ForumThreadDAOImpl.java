package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.heygis.constants.ForumConstant;
import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumThread;
import com.heygis.dto.ForumsThreadPage;
import com.heygis.dao.interfaces.ForumThreadDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ForumThreadDAOImpl extends DAOSupport implements ForumThreadDAO {

    public int addThread(ForumThread thread, ForumPost post) {
        try {
            this.openConn();
            String sql = "insert into forum_thread (fid,typeid,sortid,author,author_uid,"
                    + "author_account,subject,dateline,lastpost,attachment)values(?,?,?,?,?,?,?,?,?,?);";
            int exeNum = this.execUpdate(sql, thread.getFid(), thread.getTypeid(), thread.getSortid(), thread.getAuthor(),
                    thread.getAuthorUid(), thread.getAuthorAuthor(), thread.getSubject(), new Date().getTime(),
                    new Date().getTime(), thread.getAttachment());
            if (exeNum == 1) {
                int tid = this.LAST_INSERT_ID();
                //post.setTid(tid);
                //forumPostDAO.addPost(post);
                return tid;
            } else {
                return ForumConstant.WRONG_TID;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ForumConstant.WRONG_TID;
        } finally {
            this.close();
        }

    }

    public boolean delThread(int tid) {
        try {
            this.openConn();
            String sql = "update forum_thread display=0 where tid=?;";
            int updateNum = this.execUpdate(sql, tid);

            if (updateNum == 1)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return false;
    }

    public boolean updateThreadLastPost(ForumPost post) {
        try {
            this.openConn();
            String sql = "UPDATE forum_thread SET lastpost=? ,lastposter=? ,lastposter_uid=?,replies=replies+1 where tid=?;";
            int updateNum = this.execUpdate(sql, new Date().getTime(), post.getAuthor(), post.getAuthorUid(), post.getTid());
            if (updateNum == 1)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.close();
        }
    }

    //统计总数目来做判断是否最后一页，不太好，后面最好改下
    public ForumsThreadPage getThreadPageByFid(int fid, int page) {
        try {
            this.openConn();

            int begin = (page - 1) * 30;
            int end = 30;
            String sql = "select forum_thread.*,users_info.nickname from forum_thread,users_info "
                    + "where forum_thread.author_uid=users_info.uid and fid=? and display=1 order by lastpost DESC limit ?,?;";
            ResultSet rs = this.execQuery(sql, fid, begin, end);

            ForumsThreadPage threadPage = new ForumsThreadPage(fid, page);
            resultSet2ForumsThreadPage(rs, threadPage);
            return threadPage;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

    public ForumsThreadPage getThreadPageByUid(int uid, int page) {
        try {
            this.openConn();

            int begin = (page - 1) * 30;
            int end = 30;
            String sql = "select forum_thread.*,users_info.nickname from forum_thread,users_info "
                    + "where forum_thread.author_uid=users_info.uid and author_uid=? and display=1 order by dateline desc limit ?,?;";
            ResultSet rs = this.execQuery(sql, uid, begin, end);
            ForumsThreadPage threadPage = new ForumsThreadPage(0, page);

            resultSet2ForumsThreadPage(rs, threadPage);
            return threadPage;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return null;
    }

    public int getThreadCountByFid(int fid) {
        try {
            this.openConn();

            int count = 0;
            String sql = "select count(*) from forum_thread where fid=? and display=1";
            ResultSet countRs = this.execQuery(sql, fid);
            while (countRs.next()) {
                count = countRs.getInt(1);
            }

            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return ForumConstant.WRONG_THREAD_COUNT;
    }

    private void resultSet2ForumsThreadPage(ResultSet rs, ForumsThreadPage threadPage) throws SQLException {
        int i = 0;
        while (rs.next()) {
            threadPage.setThread(i, new ForumThread(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(18),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    new Date(rs.getLong(9)),
                    new Date(rs.getLong(10)),
                    rs.getString(11),
                    rs.getInt(12),
                    rs.getInt(13),
                    rs.getInt(14),
                    rs.getInt(15),
                    rs.getInt(16),
                    rs.getInt(17)));
            i++;
        }
    }
}
