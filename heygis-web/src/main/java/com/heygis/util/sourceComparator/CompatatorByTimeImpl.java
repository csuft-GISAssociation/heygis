package com.heygis.util.sourceComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.heygis.dto.Source;

public class CompatatorByTimeImpl implements Comparator<Source>{

	public int compare(Source s1, Source s2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			Date d1 = sdf.parse(s1.getUpload_time());
			Date d2 = sdf.parse(s2.getUpload_time());
			if(d1.after(d2)){
				return 1;
			}else{
				return -1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
