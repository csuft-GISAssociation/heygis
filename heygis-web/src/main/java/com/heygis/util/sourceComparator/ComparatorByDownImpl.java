package com.heygis.util.sourceComparator;

import java.util.Comparator;

import com.heygis.dto.Source;

public class ComparatorByDownImpl implements Comparator<Source>{

	public int compare(Source s1, Source s2) {
		Double l1= new Double(s1.getDownload_times());
		Double l2= new Double(s2.getDownload_times());
		return l2.compareTo(l1);
	}

}
