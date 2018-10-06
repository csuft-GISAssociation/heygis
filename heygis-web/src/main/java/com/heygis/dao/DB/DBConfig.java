package com.heygis.dao.DB;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConfig {

	private static String url;

	private static String driverName;

	private static String userName;

	private static String password;

	//改使用spring读取注入配置，不再自己读文件
//	static{
//		try {
//			Properties props = new Properties();
//			Class cls = DBConfig.class;
//			ClassLoader loader = cls.getClassLoader();
//			InputStream in = loader.getResourceAsStream("db.properties");
//			props.load(in);
//
//			driverName = props.getProperty("driverName");
//			url = props.getProperty("url");
//			userName = props.getProperty("userName");
//			password = props.getProperty("password");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static String getUrl() {
		return url;
	}

	public static String getDriverName() {
		return driverName;
	}

	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

	@Value("#{setting[db_url]}")
	public void setUrl(String url) {
		System.out.println();
		DBConfig.url = url;
	}

	@Value("#{setting[db_driver_name]}")
	public void setDriverName(String driverName) {
		DBConfig.driverName = driverName;
	}

	@Value("#{setting[db_user_name]}")
	public void setUserName(String userName) {
		DBConfig.userName = userName;
	}

	@Value("#{setting[db_password]}")
	public void setPassword(String password) {
		DBConfig.password = password;
	}
}
