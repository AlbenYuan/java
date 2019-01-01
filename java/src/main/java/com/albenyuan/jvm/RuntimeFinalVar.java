package com.albenyuan.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-11-30 22:18
 */
public class RuntimeFinalVar {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        new Integer(1);
        while (true) {
            String  s = new String("123").intern();
            list.add(s);
        }
    }

}
