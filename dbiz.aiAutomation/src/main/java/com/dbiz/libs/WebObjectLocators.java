package com.dbiz.libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebObjectLocators extends ObjectLocators{
	
	public  String getPaths(String key) {
		String propKey = null;
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("../dbiz.aiAutomation/ObjectRepo/PROP/Web_ObjectRepository.properties");
            properties.load(fileInputStream);
          propKey = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  propKey;
    }
}
