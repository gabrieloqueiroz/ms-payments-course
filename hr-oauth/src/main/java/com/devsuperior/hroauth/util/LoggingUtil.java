package com.devsuperior.hroauth.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

    private static Logger logger;

    public static void info( Class<?> thisClass, String msg){
        logger = LoggerFactory.getLogger(thisClass);
        logger.info(msg);
    }

    public static void info( Class<?> thisClass, String title, String msg){
        logger = LoggerFactory.getLogger(thisClass);
        logger.info(title, msg);
    }

    public static void error(Class<?> thisClass, String msg){
        logger = LoggerFactory.getLogger(thisClass);
        logger.error(msg);
    }
}
