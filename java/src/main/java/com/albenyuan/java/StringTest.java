package com.albenyuan.java;

/**
 * @Author Alben Yuan
 * @Date 2018-03-15 15:09
 */
public class StringTest {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    char[] value = {};

    public static void main(String[] args) {
        String string = new String();
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        System.out.println(new StringTest().newCapacity(1));
    }


    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
                ? hugeCapacity(minCapacity)
                : newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
                ? minCapacity : MAX_ARRAY_SIZE;
    }
}
