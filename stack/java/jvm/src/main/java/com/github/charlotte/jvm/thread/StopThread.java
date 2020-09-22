package com.github.charlotte.jvm.thread;

public class StopThread implements Runnable {
 
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
        }
        System.out.println(Thread.currentThread().isInterrupted());

    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }

}