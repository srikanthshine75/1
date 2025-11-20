package com.automation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ResourcesConfig - Configuration properties loader
 * Loads configuration from properties files in resources folder
 */
public class ResourcesConfig {
    
    private static Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    
    static {
        loadProperties();
    }
    
    /**
     * Load properties from config.properties file
     */
    private static void loadProperties() {
        try {
            File configFile = new File(CONFIG_PATH);
            if (configFile.exists()) {
                FileInputStream fis = new FileInputStream(configFile);
                properties.load(fis);
                fis.close();
                System.out.println("Configuration loaded successfully from: " + CONFIG_PATH);
            } else {
                System.out.println("Config file not found at: " + CONFIG_PATH);
            }
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get property value by key
     * @param key Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.out.println("Property not found: " + key);
            return "";
        }
        return value;
    }
    
    /**
     * Get property value with default fallback
     * @param key Property key
     * @param defaultValue Default value if key not found
     * @return Property value or default
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Get integer property
     * @param key Property key
     * @return Integer value
     */
    public static int getIntProperty(String key) {
        String value = getProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Error converting property to int: " + key);
            return 0;
        }
    }
    
    /**
     * Get boolean property
     * @param key Property key
     * @return Boolean value
     */
    public static boolean getBooleanProperty(String key) {
        String value = getProperty(key);
        return Boolean.parseBoolean(value);
    }
    
    /**
     * Check if property exists
     * @param key Property key
     * @return True if property exists
     */
    public static boolean hasProperty(String key) {
        return properties.containsKey(key);
    }
    
    /**
     * Reload properties (useful for refreshing configuration)
     */
    public static void reloadProperties() {
        properties.clear();
        loadProperties();
    }
    
    /**
     * Get all properties
     * @return Properties object
     */
    public static Properties getAllProperties() {
        return properties;
    }
}
