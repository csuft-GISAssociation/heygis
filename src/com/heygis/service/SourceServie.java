package com.heygis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.SourceDAOImpl;
import com.heygis.util.ComparatorByAlphaImpl;
import com.heygis.util.ComparatorByDownImpl;
import com.heygis.util.ComparatorImpl;
import com.heygis.util.CompatatorByTimeImpl;

public class SourceServie {
	SourceDAOImpl sdi = null;
	ComparatorImpl comp = null;
	ComparatorByAlphaImpl compAlpha = null;
	ComparatorByDownImpl comDown = null;
	CompatatorByTimeImpl comTime = null;
	public SourceServie(){
		sdi = new SourceDAOImpl();
	}
	public List<SourceOne> getSourceOneList(){
		return sdi.getSourceOne();
	}
	public List<SourceTwo> getSourceTwoList(){
		return sdi.getSourceTwo();
	}
	public List<SourceThree> getSourceThreeList(){
		return sdi.getSourceThree();
	}
	public List<SourceFour> getSourceFourList(){
		return sdi.getSourceFour();
	}
	//按上传时间进行排序
	public List sortByTime(String sourceType){
		if(sourceType.equals("1")){
			List<SourceOne> sourceOneList = sdi.getSourceOne();
			comTime = new CompatatorByTimeImpl();
			Collections.sort(sourceOneList, comTime);
			return sourceOneList;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> sourceTwoList = sdi.getSourceTwo();
			comTime = new CompatatorByTimeImpl();
			Collections.sort(sourceTwoList, comTime);
			return sourceTwoList;	
		}
		if(sourceType.equals("3")){
			List<SourceThree> sourceThreeList = sdi.getSourceThree();
			comTime = new CompatatorByTimeImpl();
			Collections.sort(sourceThreeList, comTime);
			return sourceThreeList;
		}
		if(sourceType.equals("4")){
			List<SourceFour> sourceFourList = sdi.getSourceFour();
			comTime = new CompatatorByTimeImpl();
			Collections.sort(sourceFourList, comTime);
			return sourceFourList;
		}
		return null;	 	
	}
	//按文件下载次数进行排序
	public List sortByDown(String sourceType){
		if(sourceType.equals("1")){
			List<SourceOne> sourceOneList = sdi.getSourceOne();
			comDown = new ComparatorByDownImpl();
			Collections.sort(sourceOneList, comDown);
			return sourceOneList;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> sourceTwoList = sdi.getSourceTwo();
			comDown = new ComparatorByDownImpl();
			Collections.sort(sourceTwoList, comDown);
			return sourceTwoList;	
		}
		if(sourceType.equals("3")){
			List<SourceThree> sourceThreeList = sdi.getSourceThree();
			comDown = new ComparatorByDownImpl();
			Collections.sort(sourceThreeList, comDown);
			return sourceThreeList;
		}
		if(sourceType.equals("4")){
			List<SourceFour> sourceFourList = sdi.getSourceFour();
			comDown = new ComparatorByDownImpl();
			Collections.sort(sourceFourList, comDown);
			return sourceFourList;
		}
		return null;	 	
	}
	//按文件大小进行排序
	public List sortByFileSize(String sourceType){
		if(sourceType.equals("1")){
			List<SourceOne> sourceOneList = sdi.getSourceOne();
			comp = new ComparatorImpl();
			Collections.sort(sourceOneList, comp);
			return sourceOneList;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> sourceTwoList = sdi.getSourceTwo();
			comp = new ComparatorImpl();
			Collections.sort(sourceTwoList, comp);
			return sourceTwoList;	
		}
		if(sourceType.equals("3")){
			List<SourceThree> sourceThreeList = sdi.getSourceThree();
			comp = new ComparatorImpl();
			Collections.sort(sourceThreeList, comp);
			return sourceThreeList;
		}
		if(sourceType.equals("4")){
			List<SourceFour> sourceFourList = sdi.getSourceFour();
			comp = new ComparatorImpl();
			Collections.sort(sourceFourList, comp);
			return sourceFourList;
		}
		return null;	 	
	}
	//按文件名称进行排序
	public List sortByAlpha(String sourceType){
		if(sourceType.equals("1")){
			List<SourceOne> sourceOneList = sdi.getSourceOne();
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceOneList, compAlpha);
			return sourceOneList;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> sourceTwoList = sdi.getSourceTwo();
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceTwoList, compAlpha);
			return sourceTwoList;	
		}
		if(sourceType.equals("3")){
			List<SourceThree> sourceThreeList = sdi.getSourceThree();
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceThreeList, compAlpha);
			return sourceThreeList;
		}
		if(sourceType.equals("4")){
			List<SourceFour> sourceFourList = sdi.getSourceFour();
			compAlpha = new ComparatorByAlphaImpl();
			Collections.sort(sourceFourList, compAlpha);
			return sourceFourList;
		}
		return null;
	}
	//按搜索条件进行排序
	public List searchByCtx(String sourceType,String searchCtx){
		if(sourceType.equals("1")){
			List<SourceOne> newlist = new ArrayList<SourceOne>();
			List<SourceOne> sourceOneList = sdi.getSourceOne();
			for(SourceOne source : sourceOneList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> newlist = new ArrayList<SourceTwo>();
			List<SourceTwo> sourceTwoList = sdi.getSourceTwo();
			for(SourceTwo source : sourceTwoList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		if(sourceType.equals("3")){
			List<SourceThree> newlist = new ArrayList<SourceThree>();
			List<SourceThree> sourceThreeList = sdi.getSourceThree();
			for(SourceThree source : sourceThreeList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		if(sourceType.equals("4")){
			List<SourceFour> newlist = new ArrayList<SourceFour>();
			List<SourceFour> sourceFourList = sdi.getSourceFour();
			for(SourceFour source : sourceFourList){
				String name = source.getName().toLowerCase();
				int result = name.indexOf(searchCtx.toLowerCase());
				if(result != -1){
					newlist.add(source);
				}
			}
			return newlist;
		}
		return null;
	}
	public boolean addCount(String sourceName){
		if(sdi.addCount(sourceName)){
			return true;
		}
		return false;
	}
}
