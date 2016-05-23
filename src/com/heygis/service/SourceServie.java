package com.heygis.service;

import java.util.List;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.interfaces.SourceDAOImpl;

public class SourceServie {
	SourceDAOImpl sdi = null;
	public SourceServie(){
		sdi = new SourceDAOImpl();
	}
	public List<SourceOne> getSourceOneList(){
		return sdi.getSourceOne();
	}
	public List<SourceTwo> getSourceTwoList(){
		return sdi.getSourceTwo();
	}
	public List<SourceThree> getSourceThreeList(){
		return sdi.getSourceThree();
	}
	public List<SourceFour> getSourceFourList(){
		return sdi.getSourceFour();
	}
}
