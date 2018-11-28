package com.albenyuan.java;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Alben Yuan
 * @Date 2018-04-04 16:16
 */


public class Collection {

    private Map<String, Object> map;

    private int times = 20;

    @Test
    public void testHashMap() {
        map = new HashMap<>(32);
        addToMap(map);
    }

    @Test
    public void testConcurrentHashMap() {
        map = new ConcurrentHashMap<>();
        map.put("1234", "1234567890");
//        addToMap(map);
    }

    //    public static void main(String[] args) {
//        Map<String, String> hashMap = new HashMap<>();
//        Map<String, String> hashTable = new Hashtable<>();
//        Map<String, String> linkedHashMap = new LinkedHashMap<>();
//        Map<String, String> weakHashMap = new WeakHashMap<>();
//        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        List<String> list = new ArrayList<>();
//
//        Thread.State state = Thread.currentThread().getState();
////        Object[] arrays = new Object[10];
////        Object[] a = new Object[10];
////        Object[] a1 = {null, null, null};
////        int i[];
////        int[] i1;
////        int[] i2[];
//
////        System.out.println(a1.length);
//    }


    private void addToMap(Map<String, Object> map) {
        for (Integer i = 0; i < times; i++) {
            map.put(String.valueOf(i), i);
        }
    }


}
