package com.albenyuan.jvm.classloader;

import java.io.*;

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
        // 获取类的class文件字节数组
        byte[] classData = getClassByte(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }


    private byte[] getClassByte(String className) {
        // 读取类文件的字节
        String path = convertClassNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String convertClassNameToPath(String className) {
        return dir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

}
