package com.heygis.dao.interfaces;

import java.util.List;

import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;

public interface SourceDAO {
	public List<SourceOne> getSourceOne();
	public List<SourceTwo> getSourceTwo();
	public List<SourceThree> getSourceThree();
	public List<SourceFour> getSourceFour();
	public boolean addCount(String sourceName);
}
