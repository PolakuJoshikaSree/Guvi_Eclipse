package com.chubb.basic;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class Main {

    final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.debug("TMH debug message");
        logger.info("TMH info message");

        try {
            int x = 10 / 0;
        } catch (Exception e) {
            logger.error("Error happened", e);
        }
    }
}
