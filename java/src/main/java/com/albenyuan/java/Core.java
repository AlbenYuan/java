package com.albenyuan.java;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-04-19 17:33
 */
public class Core {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void switchTest() {

        switchCase(0);
        switchCase(1);
        switchCase(2);

    }

    private void switchCase(int i) {
        switch (i) {
            case 1:
                logger.info("i={}, case 1,", i);
            case 2:
                logger.info("i={}, case 2", i);
//                break;
            case 3:
                logger.info("i={}, case 3", i);
            default:
                logger.info("i={}, default", i);
        }
    }

}
