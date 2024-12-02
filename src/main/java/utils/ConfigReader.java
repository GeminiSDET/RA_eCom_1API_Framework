package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties loadProperties(String filePath) throws Exception {
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream(filePath);
		prop.load(fis);
		return prop;
	}
}
