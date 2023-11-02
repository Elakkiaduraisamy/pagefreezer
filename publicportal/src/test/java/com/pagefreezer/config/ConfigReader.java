package com.pagefreezer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties = new Properties();

    static {
        try ( InputStream inputStream =
                      ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error("Unable to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    // Add other methods to get other configurations as needed
}

