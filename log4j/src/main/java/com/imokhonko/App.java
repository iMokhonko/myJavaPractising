package com.imokhonko;

import org.apache.log4j.Logger;

public class App {

    private final static Logger logger = Logger.getLogger (App.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            logger.info ("info message");
            logger.debug("debug message");
            logger.warn ("warn message");
            logger.fatal("fatal message");
            logger.error("error message");
            logger.trace("trace message");
        }
    }


}

