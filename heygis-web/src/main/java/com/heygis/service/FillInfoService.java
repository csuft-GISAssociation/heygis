package com.heygis.service;

import com.heygis.dto.User;
import com.heygis.dao.UserDAOImpl;

public class FillInfoService {
	UserDAOImpl udi = new UserDAOImpl();
	public boolean fillInfo(User user){
		return udi.fillInfo(user);
	}
}
