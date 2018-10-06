package com.heygis.service.interfaces;

import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface SourceService {

    public List<SourceOne> getSourceOneList();

    public List<SourceTwo> getSourceTwoList();

    public List<SourceThree> getSourceThreeList();

    public List<SourceFour> getSourceFourList();

    //按上传时间进行排序
    public List sortByTime(String sourceType);

    //按文件下载次数进行排序
    public List sortByDown(String sourceType);

    //按文件大小进行排序
    public List sortByFileSize(String sourceType);

    //按文件名称进行排序
    public List sortByAlpha(String sourceType);

    //按搜索条件进行排序
    public List searchByCtx(String sourceType, String searchCtx);

    public boolean addCount(String sourceName);
}
