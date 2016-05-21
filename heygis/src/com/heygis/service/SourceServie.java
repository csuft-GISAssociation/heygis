package com.heygis.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.interfaces.SourceDAOImpl;

public class SourceServie {
	SourceDAOImpl sdi = null;
	ResultSet rs = null;
	SourceOne sourceOne = null;
	SourceTwo sourceTwo = null;
	SourceThree sourceThree = null;
	SourceFour sourceFour = null;
	List<SourceOne> sourceOneList = null;
	List<SourceTwo> sourceTwoList = null;
	List<SourceThree> sourceThreeList = null;
	List<SourceFour> sourceFourList = null;
	public SourceServie(){
		sdi = new SourceDAOImpl();
		sourceOneList = new ArrayList<SourceOne>();
		sourceTwoList = new ArrayList<SourceTwo>();
		sourceThreeList = new ArrayList<SourceThree>();
		sourceFourList = new ArrayList<SourceFour>();
	}
	public List<SourceOne> getSourceOneList(){
		rs = sdi.getSource().get(0);
		try {
			while(rs.next()){
				sourceOne = new SourceOne();
				sourceOne.setName(rs.getString("name"));
				sourceOne.setIntroduction(rs.getString("introduction"));
				sourceOne.setFile_size(rs.getString("file_size"));
				sourceOne.setDownload_link(rs.getString("download_link"));
				sourceOne.setIcon(rs.getString("icon"));
				sourceOne.setUpload_time(rs.getString("upload_time"));
				sourceOne.setDownload_times(rs.getLong("download_times"));
				sourceOne.setLevel(rs.getString("level"));
				sourceOne.setUploader(rs.getString("uploader"));
				sourceOneList.add(sourceOne);
			}
			return sourceOneList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<SourceTwo> getSourceTwoList(){
		rs = sdi.getSource().get(1);
		try {
			while(rs.next()){
				sourceTwo = new SourceTwo();
				sourceTwo.setName(rs.getString("name"));
				sourceTwo.setIntroduction(rs.getString("introduction"));
				sourceTwo.setFile_size(rs.getString("file_size"));
				sourceTwo.setDownload_link(rs.getString("download_link"));
				sourceTwo.setIcon(rs.getString("icon"));
				sourceTwo.setUpload_time(rs.getString("upload_time"));
				sourceTwo.setDownload_times(rs.getLong("download_times"));
				sourceTwo.setUploader(rs.getString("uploader"));
				sourceTwoList.add(sourceTwo);
			}
			return sourceTwoList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<SourceThree> getSourceThreeList(){
		rs = sdi.getSource().get(2);
		try {
			while(rs.next()){
				sourceThree = new SourceThree();
				sourceThree.setName(rs.getString("name"));
				sourceThree.setIntroduction(rs.getString("introduction"));
				sourceThree.setFile_size(rs.getString("file_size"));
				sourceThree.setDownload_link(rs.getString("download_link"));
				sourceThree.setDownload_link_offical(rs.getString("download_link_offical"));
				sourceThree.setIcon(rs.getString("icon"));
				sourceThree.setCracking(rs.getBoolean("cracking"));
				sourceThree.setUpload_time(rs.getString("upload_time"));
				sourceThree.setDownload_times(rs.getLong("download_times"));
				sourceThreeList.add(sourceThree);
			}
			return sourceThreeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<SourceFour> getSourceFourList(){
		rs = sdi.getSource().get(3);
		try {
			while(rs.next()){
				sourceFour = new SourceFour();
				sourceFour.setName(rs.getString("name"));
				sourceFour.setIntroduction(rs.getString("introduction"));
				sourceFour.setFile_size(rs.getString("file_size"));
				sourceFour.setDownload_link(rs.getString("download_link"));
				sourceFour.setIcon(rs.getString("icon"));
				sourceFour.setUpload_time(rs.getString("upload_time"));
				sourceFour.setDownload_times(rs.getLong("download_times"));
				sourceFour.setUploader(rs.getString("uploader"));
				sourceFour.setFiletype(rs.getString("filetype"));
				sourceFourList.add(sourceFour);
			}
			return sourceFourList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
