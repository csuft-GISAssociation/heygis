package com.heygis.dao.DB;

import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
	private static String url;
	private static String driverName;
	private static String userName;
	private static String password;

	static{
		try {
			Properties props = new Properties();
			Class cls = DBConfig.class;
			ClassLoader loader = cls.getClassLoader();
			InputStream in = loader.getResourceAsStream("db.properties");
			props.load(in);
			
			driverName = props.getProperty("driverName");
			url = props.getProperty("url");
			userName = props.getProperty("userName");
			password = props.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DBConfig() {
       this.init();
	}

	// ∂¡≈‰÷√Œƒº˛
	private void init() {
		try {
			Properties props = new Properties();
			Class cls = DBConfig.class;
			ClassLoader loader = cls.getClassLoader();
			InputStream in = loader.getResourceAsStream("db.properties");
			props.load(in);
			
			this.driverName = props.getProperty("driverName");
			this.url = props.getProperty("url");
			this.userName = props.getProperty("userName");
			this.password = props.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

}
