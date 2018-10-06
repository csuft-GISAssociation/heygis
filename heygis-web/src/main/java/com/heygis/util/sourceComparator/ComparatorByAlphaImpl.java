package com.heygis.util.sourceComparator;

import java.util.Comparator;

import com.heygis.dto.Source;

public class ComparatorByAlphaImpl implements Comparator<Source>{

	public int compare(Source s1, Source s2) {
		char str1 = s1.getName().toLowerCase().charAt(0);
		char str2 = s2.getName().toLowerCase().charAt(0);
		Double l1 =(double)str1;
		Double l2 =(double)str2;
		return l1.compareTo(l2);	
	}

}
