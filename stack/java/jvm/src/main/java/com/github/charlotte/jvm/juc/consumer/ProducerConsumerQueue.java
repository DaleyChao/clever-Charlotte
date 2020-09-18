package com.github.charlotte.jvm.juc.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Daniel
 */
public class ProducerConsumerQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Runnable producer = ()->{
            while (true) {
                try {
                    queue.put(new Object());
                    System.out.println(Thread.currentThread().getName() + " 生产 +1");
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ;

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = ()->{
            while (true) {
                try {
                    queue.take();
                    System.out.println(Thread.currentThread().getName() + " 消费 -1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ;

        new Thread(consumer).start();
        new Thread(consumer).start();
    }


}
