package com.github.charlotte.jvm.juc;

import sun.misc.Unsafe;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTest {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ReentrantLock loc = new ReentrantLock();
//        loc.lock();
//        Thread a =new Thread(()->{
//            System.out.println("1");
//            loc.lock();
//            System.out.println("1");
//        });a.start();
//        Thread.sleep(100000L);
////        loc.unlock();
//
//
////        new Thread(()->{loc.lock();});
//
//    }

    public static void main(String[] args) throws InterruptedException, IllegalAccessException, InstantiationException {

        Unsafe unsafe = Unsafe.class.newInstance();
        unsafe.park(false,0);

    }
}
