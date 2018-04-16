package com.albenyuan.java.classloader;

/**
 * @Author Alben Yuan
 * @Date 2018-04-16 16:57
 */
public class FileClassLoader extends ClassLoader {

    private String dir;

    public FileClassLoader(String dir) {
        this.dir = dir;
    }

    // 编写获取类的字节码并创建class对象的逻辑
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //...省略逻辑代码
        return null;
    }

    //编写读取字节流的方法
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        //省略代码....
        return null;
    }
}
