package com.heygis.dao.interfaces;

import java.util.List;

public interface PageViewCounterDAO {
	int getLastNum();
	boolean store(int num, List<String> ip, List<Long> time, List<String> userAgent);
}
