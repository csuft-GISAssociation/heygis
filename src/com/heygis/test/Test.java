package com.heygis.test;

import java.util.List;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.service.SourceServie;
import com.heygis.servlet.SourceServlet;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SourceServie ss = new SourceServie();
		System.out.println("1");
		List<SourceOne> li = ss.getSourceOneList();
		System.out.println("11");
		List<SourceTwo> lii = ss.getSourceTwoList();
		System.out.println("111");
		List<SourceThree> liii = ss.getSourceThreeList();
		List<SourceFour> l = ss.getSourceFourList();
		System.out.println(li.size());
		System.out.println(lii.size());
		System.out.println(liii.size());
		System.out.println(l.size());

	}

}
