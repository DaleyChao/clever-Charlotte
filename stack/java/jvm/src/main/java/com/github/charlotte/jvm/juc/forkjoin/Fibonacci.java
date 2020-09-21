package com.github.charlotte.jvm.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 斐波那且数列
 * @author Daniel
 */
public class Fibonacci extends RecursiveTask<Integer> {

    int n;

    Fibonacci(int n){
        this.n=n;
    }

    @Override
    protected Integer compute() {
        if(n<=1){
            return n;
        }
        Fibonacci a = new Fibonacci(n -1);
        a.fork();
        Fibonacci b = new Fibonacci(n -2);
        b.fork();

        return a.join()+b.join();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        for(int i=0;i<100;i++) {
            ForkJoinTask forkJoinTask = forkJoinPool.submit(new Fibonacci(i));
            System.out.println(forkJoinTask.get() + " -- "+i);
        }

    }
}
