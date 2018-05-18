package com.albenyuan.java;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Alben Yuan
 * @Date 2018-04-04 16:16
 */

public class Collection {


    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashTable = new Hashtable<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> weakHashMap = new WeakHashMap<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        List<String> list = new ArrayList<>();

        Thread.State state = Thread.currentThread().getState();
//        Object[] arrays = new Object[10];
//        Object[] a = new Object[10];
//        Object[] a1 = {null, null, null};
//        int i[];
//        int[] i1;
//        int[] i2[];

//        System.out.println(a1.length);
    }


}
