package org.example;

import ch.qos.logback.classic.Level;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class LevelLogTest {
    @Test
    public void levelTrue()
    {
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("com.foo");

        // 设置 logger 的级别为 INFO
        logger.setLevel(Level.INFO);

        // 这条日志可以打印，因为 WARN >= INFO
        logger.warn("警告信息");
        // 这条日志不会打印，因为 DEBUG < INFO
        logger.debug("调试信息");

        // "com.foo.bar" 会继承 "com.foo" 的有效级别
        Logger barLogger = LoggerFactory.getLogger("com.foo.bar");
        // 这条日志会打印，因为 INFO >= INFO
        barLogger.info("子级信息");
        // 这条日志不会打印，因为 DEBUG < INFO
        barLogger.debug("子级调试信息");

        assertTrue( true );
    }


    @Test
    public void paramsTrue()
    {
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(App.class);
        Object entry = new App();
        logger.debug("The entry is {}", entry);

        logger.debug("The new entry is {}, It replaces {}.", entry, entry);

        assertTrue( true );
    }
}
