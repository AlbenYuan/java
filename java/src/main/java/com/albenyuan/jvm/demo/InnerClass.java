package com.albenyuan.jvm.demo;

/**
 * @Author Alben Yuan
 * @Date 2018-12-03 14:37
 */
public class InnerClass {


    public InnerClass() {
        System.out.println("create InnerClass");
    }


    public void innerClass() {

        final String test = "";
        class MethodInnerClass {

            // inner class can not have static declarations
//            static {
//
//            }

            public void method() {
                System.out.println("MethodInnerClass method:" + test);
            }
        }
        new MethodInnerClass().method();
    }

    public static class StaticClass {

        static {
            System.out.println("StaticClass static");
        }

        public StaticClass() {
            System.out.println("create StaticClass");
        }
    }

    private class ClassInner{
//        static {
//
//        }



    }


}
