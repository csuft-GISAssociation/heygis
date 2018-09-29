package com.heygis.service;

import com.heygis.dto.NewMember;
import com.heygis.dao.MemberDaoImpl;

public class JoinUSService {
	MemberDaoImpl mdi = null;
	public JoinUSService(){
		mdi = new MemberDaoImpl();
	}
	public boolean addMember(NewMember member){
		return mdi.addMember(member);
	}
}
