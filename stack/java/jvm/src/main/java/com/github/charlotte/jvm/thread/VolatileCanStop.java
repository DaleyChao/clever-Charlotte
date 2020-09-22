package com.github.charlotte.jvm.thread;

/**
 * 存在缺点 如果线程处于阻塞状态，感受到 中断 信号
 */
public class VolatileCanStop implements Runnable {
 
    private volatile boolean canceled = false;


    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num <= 1000000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数。");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop r = new VolatileCanStop();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(3000);
        r.canceled = true;

    }

}