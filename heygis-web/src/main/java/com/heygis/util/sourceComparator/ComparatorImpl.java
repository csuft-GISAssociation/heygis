package com.heygis.util.sourceComparator;

import java.util.Comparator;

import com.heygis.dto.Source;

public class ComparatorImpl implements Comparator<Source>{

	public int compare(Source s1, Source s2) {
		String str1 = s1.getFile_size();
		String str2 = s2.getFile_size();
		str1 = str1.substring(0,str1.length()-1);
		str2 = str2.substring(0,str2.length()-1);
		Double l1 = Double.parseDouble(str1);
		Double l2 = Double.parseDouble(str2);
		return l1.compareTo(l2);	
	}
	

}
