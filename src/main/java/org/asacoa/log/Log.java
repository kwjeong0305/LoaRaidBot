package org.asacoa.log;


import org.slf4j.LoggerFactory;

public class Log {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Log.class);

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
    }


}
