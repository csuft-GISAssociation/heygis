package com.heygis.dao.interfaces;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.heygis.dao.DAOSupport;

public class SourceDAOImpl extends DAOSupport implements SourceDAO{
	@Override
	public List<ResultSet> getSource() {
		List<ResultSet> rsList = new ArrayList<ResultSet>();
		String sql1 = "select * from sourceone";
		String sql2 = "select * from sourcetwo";
		String sql3 = "select * from sourcethree";
		String sql4 = "select * from sourcefour";
		rsList.add(this.execQuery(sql1));
		rsList.add(this.execQuery(sql2));
		rsList.add(this.execQuery(sql3));
		rsList.add(this.execQuery(sql4));
		return rsList;
	}
}
