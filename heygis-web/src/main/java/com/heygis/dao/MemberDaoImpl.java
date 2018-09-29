package com.heygis.dao;

import com.heygis.dto.NewMember;
import com.heygis.dao.interfaces.MemberDao;

public class MemberDaoImpl extends DAOSupport implements MemberDao{

	@Override
	public boolean addMember(NewMember m) {
		String sql = "INSERT INTO newmember (name,profession,tel,QQ,other,selfintro,goal) VALUES (?,?,?,?,?,?,?)";
		this.openConn();
		int result = this.execUpdate(sql,m.getName(),m.getProfession(),m.getTel(),m.getQQ(),m.getOther(),m.getSelfIntro(),m.getGoal());
		this.close();
		if(result == 1){
			return true;
		}
		return false;
	}

}
