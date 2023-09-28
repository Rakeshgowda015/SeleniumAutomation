package com.dbiz.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("Config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

