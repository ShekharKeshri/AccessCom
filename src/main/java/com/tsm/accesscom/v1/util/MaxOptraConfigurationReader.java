package com.tsm.accesscom.v1.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxOptraConfigurationReader {

    /* Creating the Logger */
    private static final Logger LOG = LoggerFactory.getLogger(MaxOptraConfigurationReader.class);
    private static Properties configReader = null;
    private static Properties defaultConfigReader = null;
   
    public String getProperty(String key) throws IllegalArgumentException {
        try {

                configReader = new Properties();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream in = classLoader.getResourceAsStream("max_optra.properties");
                configReader.load(in);
                in.close();
                
        }catch(Exception e){
        	e.printStackTrace();
        }
           
        return configReader.getProperty(key);
    }
    
    public static void setProperty(String key, String value)
            throws IllegalArgumentException {
        if (configReader == null || key == null) {
            throw new IllegalArgumentException("Either configuartion reader :" + configReader
                            + " or argument supplied key: " + key + " is null.");
        }
        configReader.setProperty(key, value);
    }

    public static Properties getConfigReader() {
        return configReader;
    }

    public static void setConfigReader(Properties configReader) {
        MaxOptraConfigurationReader.configReader = configReader;
    }
    
    public static String getDefaultProperty(String key) throws Exception {
        
        if(key == null || key.isEmpty()) {
             throw new IllegalArgumentException("Input key for the Configuration cannot be null or empty.");
        }
        if(defaultConfigReader == null) {
            try {
                defaultConfigReader = new Properties();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream in = classLoader.getResourceAsStream("max_optra.properties");
                defaultConfigReader.load(in);
                in.close();
            } catch (IOException io) {
                throw new Exception("Default Configuration file is not found.", io);
            }
             
        }
        return defaultConfigReader.getProperty(key);
    }

}