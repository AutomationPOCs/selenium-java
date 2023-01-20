package com.bnl.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigBase {
	public static Properties prop;
	public final static String LoginProperty=System.getProperty("user.dir")+"/resources/configuration/Login.properties";
	public final static String ConfigProperty=System.getProperty("user.dir")+"/resources/configuration/Config.properties";
	public final static String BrowserProperty=System.getProperty("user.dir")+"/resources/configuration/Browsers.properties";
	public final static String PDPProperty=System.getProperty("user.dir")+"/resources/configuration/PDP.properties";
    
	public static String initialiseProperty(String Property, String key) {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(Property);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}

