package org.example;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws  Exception
    {
        logger.debug("taiyonghai debug");
        logger.info("taiyonghai info");
        logger.error("taiyonghai error");
        logger.warn("taiyonghai warn");

        // 打印内部的状态
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        System.out.println("我们是好朋友");
    }
}
