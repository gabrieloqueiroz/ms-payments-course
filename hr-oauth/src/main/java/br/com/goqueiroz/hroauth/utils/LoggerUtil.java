package br.com.goqueiroz.hroauth.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggerUtil {

    private static Logger logger;

    public static void error(Class<?> sourceClass, String message){
        logger = LoggerFactory.getLogger(sourceClass);
        logger.error(message);
    }

    public static void info(Class<?> sourceClass, String message){
        logger = LoggerFactory.getLogger(sourceClass);
        logger.info(message);
    }

    public static void info(Class<?> sourceClass,String title, String message){
        logger = LoggerFactory.getLogger(sourceClass);
        logger.info(message, title);
    }
}
