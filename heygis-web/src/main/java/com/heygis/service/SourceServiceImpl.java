package com.heygis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.heygis.dao.interfaces.SourceDAO;
import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;
import com.heygis.service.interfaces.SourceService;
import com.heygis.util.sourceComparator.ComparatorByAlphaImpl;
import com.heygis.util.sourceComparator.ComparatorByDownImpl;
import com.heygis.util.sourceComparator.ComparatorImpl;
import com.heygis.util.sourceComparator.CompatatorByTimeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    SourceDAO sourceDAO = null;

    //比较器
    Comparator comp = new ComparatorImpl();
    ComparatorByAlphaImpl compAlpha = compAlpha = new ComparatorByAlphaImpl();
    ComparatorByDownImpl comDown = new ComparatorByDownImpl();
    CompatatorByTimeImpl comTime =  new CompatatorByTimeImpl();

    public List<SourceOne> getSourceOneList() {
        return sourceDAO.getSourceOne();
    }

    public List<SourceTwo> getSourceTwoList() {
        return sourceDAO.getSourceTwo();
    }

    public List<SourceThree> getSourceThreeList() {
        return sourceDAO.getSourceThree();
    }

    public List<SourceFour> getSourceFourList() {
        return sourceDAO.getSourceFour();
    }

    //按上传时间进行排序
    public List sortByTime(String sourceType) {
        if (sourceType.equals("1")) {
            List<SourceOne> sourceOneList = sourceDAO.getSourceOne();
            Collections.sort(sourceOneList, comTime);
            return sourceOneList;
        }
        if (sourceType.equals("2")) {
            List<SourceTwo> sourceTwoList = sourceDAO.getSourceTwo();
            Collections.sort(sourceTwoList, comTime);
            return sourceTwoList;
        }
        if (sourceType.equals("3")) {
            List<SourceThree> sourceThreeList = sourceDAO.getSourceThree();
            Collections.sort(sourceThreeList, comTime);
            return sourceThreeList;
        }
        if (sourceType.equals("4")) {
            List<SourceFour> sourceFourList = sourceDAO.getSourceFour();
            Collections.sort(sourceFourList, comTime);
            return sourceFourList;
        }
        return null;
    }

    //按文件下载次数进行排序
    public List sortByDown(String sourceType) {
        if (sourceType.equals("1")) {
            List<SourceOne> sourceOneList = sourceDAO.getSourceOne();
            Collections.sort(sourceOneList, comDown);
            return sourceOneList;
        }
        if (sourceType.equals("2")) {
            List<SourceTwo> sourceTwoList = sourceDAO.getSourceTwo();
            Collections.sort(sourceTwoList, comDown);
            return sourceTwoList;
        }
        if (sourceType.equals("3")) {
            List<SourceThree> sourceThreeList = sourceDAO.getSourceThree();
            Collections.sort(sourceThreeList, comDown);
            return sourceThreeList;
        }
        if (sourceType.equals("4")) {
            List<SourceFour> sourceFourList = sourceDAO.getSourceFour();
            Collections.sort(sourceFourList, comDown);
            return sourceFourList;
        }
        return null;
    }

    //按文件大小进行排序
    public List sortByFileSize(String sourceType) {
        if (sourceType.equals("1")) {
            List<SourceOne> sourceOneList = sourceDAO.getSourceOne();
            Collections.sort(sourceOneList, comp);
            return sourceOneList;
        }
        if (sourceType.equals("2")) {
            List<SourceTwo> sourceTwoList = sourceDAO.getSourceTwo();
            Collections.sort(sourceTwoList, comp);
            return sourceTwoList;
        }
        if (sourceType.equals("3")) {
            List<SourceThree> sourceThreeList = sourceDAO.getSourceThree();
            Collections.sort(sourceThreeList, comp);
            return sourceThreeList;
        }
        if (sourceType.equals("4")) {
            List<SourceFour> sourceFourList = sourceDAO.getSourceFour();
            Collections.sort(sourceFourList, comp);
            return sourceFourList;
        }
        return null;
    }

    //按文件名称进行排序
    public List sortByAlpha(String sourceType) {
        if (sourceType.equals("1")) {
            List<SourceOne> sourceOneList = sourceDAO.getSourceOne();
            Collections.sort(sourceOneList, compAlpha);
            return sourceOneList;
        }
        if (sourceType.equals("2")) {
            List<SourceTwo> sourceTwoList = sourceDAO.getSourceTwo();
            Collections.sort(sourceTwoList, compAlpha);
            return sourceTwoList;
        }
        if (sourceType.equals("3")) {
            List<SourceThree> sourceThreeList = sourceDAO.getSourceThree();
            Collections.sort(sourceThreeList, compAlpha);
            return sourceThreeList;
        }
        if (sourceType.equals("4")) {
            List<SourceFour> sourceFourList = sourceDAO.getSourceFour();
            Collections.sort(sourceFourList, compAlpha);
            return sourceFourList;
        }
        return null;
    }

    //按搜索条件进行排序
    public List searchByCtx(String sourceType, String searchCtx) {
        if (sourceType.equals("1")) {
            List<SourceOne> newlist = new ArrayList<SourceOne>();
            List<SourceOne> sourceOneList = sourceDAO.getSourceOne();
            for (SourceOne source : sourceOneList) {
                String name = source.getName().toLowerCase();
                int result = name.indexOf(searchCtx.toLowerCase());
                if (result != -1) {
                    newlist.add(source);
                }
            }
            return newlist;
        }
        if (sourceType.equals("2")) {
            List<SourceTwo> newlist = new ArrayList<SourceTwo>();
            List<SourceTwo> sourceTwoList = sourceDAO.getSourceTwo();
            for (SourceTwo source : sourceTwoList) {
                String name = source.getName().toLowerCase();
                int result = name.indexOf(searchCtx.toLowerCase());
                if (result != -1) {
                    newlist.add(source);
                }
            }
            return newlist;
        }
        if (sourceType.equals("3")) {
            List<SourceThree> newlist = new ArrayList<SourceThree>();
            List<SourceThree> sourceThreeList = sourceDAO.getSourceThree();
            for (SourceThree source : sourceThreeList) {
                String name = source.getName().toLowerCase();
                int result = name.indexOf(searchCtx.toLowerCase());
                if (result != -1) {
                    newlist.add(source);
                }
            }
            return newlist;
        }
        if (sourceType.equals("4")) {
            List<SourceFour> newlist = new ArrayList<SourceFour>();
            List<SourceFour> sourceFourList = sourceDAO.getSourceFour();
            for (SourceFour source : sourceFourList) {
                String name = source.getName().toLowerCase();
                int result = name.indexOf(searchCtx.toLowerCase());
                if (result != -1) {
                    newlist.add(source);
                }
            }
            return newlist;
        }
        return null;
    }

    public boolean addCount(String sourceName) {
        if (sourceDAO.addCount(sourceName)) {
            return true;
        }
        return false;
    }
}
