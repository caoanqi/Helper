package com.jerry.helper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : 曹幼林
 * @date : 2019/2/18
 */
public class LogbackUtil {
    /**
     * 定义一个全局的记录器，通过LoggerFactory获取
     */
    private final Logger logger;

    private static LogbackUtil instance;

    private LogbackUtil() {
        logger = LoggerFactory.getLogger("Helper");
    }

    public static LogbackUtil getInstance() {
        if (instance == null) {
            synchronized (LogbackUtil.class) {
                if (instance == null) {
                    instance = new LogbackUtil();
                }
            }
        }

        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

}
