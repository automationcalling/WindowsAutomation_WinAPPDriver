package com.automationcalling.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Muthu on 6/23/2018.
 * Common Methods implements here
 */
public class CommonUtil {

    private Properties prop;

    public CommonUtil() {
        InputStream inputStream = null;
        try {
            prop = new Properties();
            inputStream = ClassLoader.class.getResourceAsStream("/ApplicationConfig.properties");
            prop.load(inputStream);
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

    public String getPropertyFileValue(String key) {
        return prop.getProperty(key);
    }

}
