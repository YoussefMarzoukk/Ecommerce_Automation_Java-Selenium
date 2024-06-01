package com.nopcommerce.demo.utils;

import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private static Properties properties;

    private ConfigUtils(){
        String prodPath="src/test/java/com/nopcommerce/demo/Config/production.properties";
        properties = PropertiesUtil.loadProperties(prodPath);
    }

    public static ConfigUtils getInstance(){

        if (configUtils==null){
            configUtils= new ConfigUtils();}
        return configUtils;
    }
    public String baseURL() {
        String prop = properties.getProperty("baseurl");
        if (prop != null)
            return prop;
        throw new RuntimeException("Unable to find base url");
    }


}
