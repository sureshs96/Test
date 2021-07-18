package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigData {
	Properties prop;
	public ConfigData() {
	
		File src = new File("C:\\Users\\SURESH\\eclipse-workspace\\Twingo\\Config\\Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("config file not found"+e.getMessage());
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	public String getUrl() {
		return prop.getProperty("url");
	}
	public String getkey(String key) {
		return prop.getProperty(key);
	}
}
