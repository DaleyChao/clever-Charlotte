package com.github.charlotte.lcn;

import java.util.ArrayList;
import java.util.List;

public class test2 {


    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        Thread a = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("线程一持有锁一");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程准备一争抢锁2");
                synchronized (lock2) {
                    System.out.println("线程一获得锁2！！！");
                }
            }

        });

        Thread b = new Thread(() -> {

            synchronized (lock2) {
                System.out.println("线程二持有锁二");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程准备二争抢锁1");
                synchronized (lock1) {
                    System.out.println("线程二获得锁1！！！");
                }
            }

        });

        a.start();
        b.start();
    }

}
