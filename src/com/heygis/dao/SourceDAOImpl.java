package com.heygis.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.interfaces.SourceDAO;

public class SourceDAOImpl extends DAOSupport implements SourceDAO{
	@Override
	public List<SourceOne> getSourceOne() {
		SourceOne sourceOne = null;
		List<SourceOne> sourceOneList = new ArrayList<SourceOne>();
		String sql = "select * from sourceone";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return sourceOneList;
	}
	@Override
	public List<SourceTwo> getSourceTwo() {
		SourceTwo sourceTwo = null;
		List<SourceTwo> sourceTwoList = new ArrayList<SourceTwo>();
		String sql = "select * from sourcetwo";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return sourceTwoList;
	}

	@Override
	public List<SourceThree> getSourceThree() {
		SourceThree sourceThree = null;
		List<SourceThree> sourceThreeList = new ArrayList<SourceThree>();
		String sql = "select * from sourcethree";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return sourceThreeList;
	}

	@Override
	public List<SourceFour> getSourceFour() {
		SourceFour sourceFour = null;
		List<SourceFour> sourceFourList = new ArrayList<SourceFour>();
		String sql = "select * from sourcefour";
		this.openConn();
		ResultSet rs = this.execQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.close();
		return sourceFourList;
	}
}
