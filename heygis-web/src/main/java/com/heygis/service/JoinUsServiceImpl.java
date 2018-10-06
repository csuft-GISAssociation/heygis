package com.heygis.service;

import com.heygis.dao.interfaces.MemberDao;
import com.heygis.dto.NewMember;
import com.heygis.service.interfaces.JoinUsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 主页的加入我们
 */
public class JoinUsServiceImpl implements JoinUsService {

	@Autowired
	MemberDao memberDao;

	public boolean addMember(NewMember member){
		return memberDao.addMember(member);
	}
}
