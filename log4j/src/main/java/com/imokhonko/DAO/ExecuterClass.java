package com.imokhonko.DAO;

import org.apache.log4j.Logger;

public class ExecuterClass {

    private final static Logger logger = Logger.getLogger (ExecuterClass.class);

    public static void main(String[] args) {
        logger.info ("info message");
        logger.debug("debug message");
        logger.warn ("warn message");
        logger.fatal("fatal message");
        logger.error("error message");
        logger.trace("trace message");
    }

}
