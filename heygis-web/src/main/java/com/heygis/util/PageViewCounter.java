package com.heygis.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heygis.dao.PageViewCounterDAImpl;

public class PageViewCounter {
    private static int num = new PageViewCounterDAImpl().getLastNum() + 137;
    private static int index = 0;
    private static List<String> ip = new ArrayList<String>();
    private static List<Long> time = new ArrayList<Long>();
    private static List<String> userAgent = new ArrayList<String>();

    public static void addViewer(String _ip, String _userAgent) {
        ip.add(_ip);
        time.add(new Date().getTime());
        userAgent.add(_userAgent);
//		System.out.println(_userAgent+"ua");

        index++;
        num++;

        if (index == 50) {
            store();
        }
    }

    public static boolean store() {
        System.out.println("-----------------------");
        boolean b = new PageViewCounterDAImpl().store(num, ip, time, userAgent);
        ip.clear();
        time.clear();
        userAgent.clear();
        index = 0;
        return b;
    }

    public static int getNum() {
        return num;
    }
}
