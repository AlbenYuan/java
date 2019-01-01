package com.albenyuan.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20M -Xmx20M -XX:+HeapDumOnOutOfMemoryError
 *
 * @Author Alben Yuan
 * @Date 2018-11-28 10:24
 */
public class HeapOOM {

    private static  double d = 0;



    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

//        while (true) {
//            list.add(new OOMObject());
//        }
    }
}
