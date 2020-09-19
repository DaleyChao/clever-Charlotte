package com.github.charlotte.jvm.juc.consumer;

/**
 * @author Daniel
 */
public class ProducerConsumerWait {
    static int stock = 0;

    public static void main(String[] args) {
        final Object lock = new Object();

        Runnable producer = ()->{
            while (true){
                synchronized (lock){
                    if(stock>=10){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    stock = stock +1;
                    System.out.println("P - "+stock);
                    lock.notifyAll();
                }
            }
        };

        Runnable consumer = ()->{
            while (true){
                synchronized (lock){
                    if(stock==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    stock = stock -1;
                    System.out.println("C - "+stock);
                    lock.notifyAll();
                }
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
