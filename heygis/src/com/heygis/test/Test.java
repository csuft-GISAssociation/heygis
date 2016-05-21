package com.heygis.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.FeedbackMsg;
import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.FeedbackDAOImpl;
import com.heygis.dao.SourceDAOImpl;
import com.heygis.dao.DB.DBConnection;
import com.heygis.service.FeedbackService;
import com.heygis.service.SourceServie;

public class Test {
	public static void main(String[]args) throws SQLException{
//		DBConnection DBconn = DBConnection.getInstance();
//		for (int i = 0; i < 5; i++) {
//			long t1 = System.currentTimeMillis();
//			Connection conn = DBconn.getConnection();
//			conn.close();
//			long t2 = System.currentTimeMillis();
//			System.out.println(t2-t1);
//		}
//		List<SourceOne>l1 =  new SourceServie().getSourceOneList();
//		System.out.println("12");
//		List<SourceTwo>l2 =  new SourceServie().getSourceTwoList();
//		System.out.println("123");
		List<SourceThree>l3 =  new SourceServie().getSourceThreeList();
		System.out.println("1234");
//		List<SourceFour>l4 =  new SourceServie().getSourceFourList();
//		System.out.println(l1.size());
//		System.out.println(l2.size());
		System.out.println(l3.size());
//		System.out.println(l4.size());
	}
}
