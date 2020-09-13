package com.github.charlotte.jvm.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Daniel
 */
public class UnsafeUtil {


    public static void main(String[] args) throws InterruptedException, IllegalAccessException, InstantiationException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        // null 是因为成员变量 unsafe 是 static 类型，否则需要传入对象
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        Thread a = Thread.currentThread();
        new Thread(()->{
            try {
                Thread.sleep(5000L);
                unsafe.unpark(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("阻塞...");
        unsafe.park(false,0);
        System.out.println("继续");


    }
}
