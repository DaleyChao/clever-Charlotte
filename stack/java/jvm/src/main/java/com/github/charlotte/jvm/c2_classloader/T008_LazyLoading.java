package com.github.charlotte.jvm.c2_classloader;

public class T008_LazyLoading { //严格讲应该叫lazy initialzing，因为java虚拟机规范并没有严格规定什么时候必须loading,但严格规定了什么时候initialzing
    public static void main(String[] args) throws Exception {
        //P p;
        //X x = new X();
//        System.out.println(P.i);
        System.out.println(P.j);
//        Class.forName("com.github.charlotte.jvm.c2_classloader.T008_LazyLoading$P");
//        Class.forName("com.github.charlotte.jvm.c2_classloader.T008_LazyLoading$X");

    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
            System.out.println(i);
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
