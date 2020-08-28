package com.github.charlotte.jvm.thread;

public class StopDuringSleep {
 
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

                while (!Thread.currentThread().isInterrupted() && num <= 1000) {
                    System.out.println(num);
                    num++;
                    System.out.println(Thread.currentThread().isInterrupted());
                    try {
                    Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().isInterrupted());
                    }
                }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }

    //再次中断
    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}