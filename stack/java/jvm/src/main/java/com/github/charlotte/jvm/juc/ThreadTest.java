package com.github.charlotte.jvm.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Daniel
 */
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        //提交任务，并用 Future提交返回结果
//        FutureTask
        Future<Integer> future = service.submit(new CallableTask());
        System.out.println(future.get());

    }

    public static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }



}
