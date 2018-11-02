package com.imokhonko;

import org.apache.log4j.Logger;


public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.fatal("fatal message");
        logger.error("error message");
        logger.warn("warn message");
        logger.debug("debug message");
        logger.info("info message");
        logger.trace("trace message");
    }

}
