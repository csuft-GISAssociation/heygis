package com.heygis.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import com.heygis.dao.interfaces.PageViewCounterDAO;
import org.springframework.stereotype.Component;

@Component
public class PageViewCounterDAImpl extends DAOSupport implements PageViewCounterDAO {

	@Override
	public int getLastNum() {
		String sql = "select count(*) from page_view_counter;";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
		int num = 0;
		try {
			if(rs.next())
				num = rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return num;
	}

	@Override
	public boolean store(int num, List<String> ip, List<Long> time, List<String> userAgent) {
		this.openConn();
		String sql;
		for(int i=0;i<ip.size();i++){
			sql = "insert into page_view_counter (ip,time,user_agent) values (?,?,?);";
			this.execUpdate(sql, ip.get(i),new Timestamp(time.get(i)),userAgent.get(i));
		}
		this.close();
		return true;
	}

}
