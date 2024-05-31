package com.nopcommerce.demo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadProperties(String filePath) {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException("Unable to Load Properties");
        }
    }
}
