package org.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class BaseLogTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void baseTrue()
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.debug("taiyonghai debug");
        logger.info("taiyonghai info");
        logger.error("taiyonghai error");
        logger.warn("taiyonghai warn");

        assertTrue( true );
    }
}
