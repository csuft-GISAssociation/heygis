package com.heygis.dao.interfaces;

import java.util.List;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;

public interface SourceDAO {
	public List<SourceOne> getSourceOne();
	public List<SourceTwo> getSourceTwo();
	public List<SourceThree> getSourceThree();
	public List<SourceFour> getSourceFour();
	public boolean addCount(String sourceName);
}
