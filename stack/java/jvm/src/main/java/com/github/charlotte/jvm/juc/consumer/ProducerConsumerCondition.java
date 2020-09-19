package com.github.charlotte.jvm.juc.consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Daniel
 */
public class ProducerConsumerCondition {
    final static int MAX = 10;
    static int stock = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();


        Runnable producer = () -> {
            while (true) {
                lock.lock();
                try {
                    if (stock >= MAX) {

                        full.await();

                    }
                    stock = stock + 1;
                    System.out.println(String.format("生产者+1 stock=%s", stock));
                    empty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable consumer = ()->{
            while (true) {
                lock.lock();
                try {
                    if (stock == 0) {

                        empty.await();

                    }
                    stock = stock - 1;
                    System.out.println(String.format("消费者-1 stock=%s", stock));
                    full.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
