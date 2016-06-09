package com.heygis.service;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.heygis.beans.User;
import com.heygis.dao.UserDAOImpl;

import sun.misc.BASE64Decoder;

public class UserIconService {
	private User user = null;
	private String path = null;
	private UserDAOImpl udi = null;
	public UserIconService(User user){
		this.user = user;
		this.path = "/usr/local/tomcat/webapps/heygis_img/icon/"+user.getAccount()+"_img.jpg";
		udi = new UserDAOImpl();
	}
	public boolean updateImg(){
		if(udi.updateIconImg(user)){
			return true;
		}
		return false;
	}
	public boolean toImg(String base64){
		if (base64 == null) { // 图像数据为空
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(base64);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(path);
			out.write(bytes);
			out.flush();
			out.close();
			if(updateImg()){
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}
}
