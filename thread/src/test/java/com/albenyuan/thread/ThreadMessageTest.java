package com.albenyuan.thread;

import com.albenyuan.thread.message.ThreadMessage;
import org.junit.Test;

/**
 * @Author Alben Yuan
 * @Date 2018-05-23 14:37
 */
public class ThreadMessageTest {

    @Test
    public void turnRun() throws Exception {
        new ThreadMessage().run();
    }
}
