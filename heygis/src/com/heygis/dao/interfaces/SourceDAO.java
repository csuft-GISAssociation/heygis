package com.heygis.dao.interfaces;

import java.sql.ResultSet;
import java.util.List;

import com.heygis.beans.SourceOne;

public interface SourceDAO {
	public List<ResultSet> getSource();
}
