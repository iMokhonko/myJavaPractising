package com.imokhonko.controller;

import com.imokhonko.model.dao.DAOClass;
import org.apache.log4j.Logger;

public class ControllerClass {

    private static final Logger logger = Logger.getLogger(DAOClass.class);

    public static void main(String[] args) {
        logger.fatal("fatal in controller");
        logger.error("error in controller");
        logger.warn("warn in controller");
        logger.debug("debug in controller");
        logger.info("info in controller");
        logger.trace("trace in controller");
    }

}
