package com.github.charlotte.algorithm;

import java.util.Random;

class Blackbox {
    private int n, secret;
    public Blackbox(int n, int seed){
        this.n = n;
        secret = new Random(seed).nextInt(n);
    } // 该构造函数根据随机数种子 seed，将 secret 随机地赋值为 [0, n) 范围中的一个数，注意，secret 通常不等于 seed
    public int getN(){
        return n;
    }  // 该函数返回构造函数里给定的 n
    public int guess(int x){
        System.out.println(1);
        int value;
        if((value=(x-secret))>0){
            return 1;
        }else if(value==0) {
            return 0;
        }else {
            return -1;
        }

    } // 该函数返回 x - secret 的正负号（-1, 0, 1）。

    int solve(Blackbox bb) {    // 该函数最终将返回 bb 的 secret
        int low = 0;
        int high = bb.getN() ;
        int middle ;
        while (low <= high) {
            middle = (low + high) / 2;
            int value;
            if ((value = bb.guess(middle)) == 0) {
                return middle;
            } else if (value==-1) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return 0;
//
//        int n = bb.getN()
//        for (int x = 0; x < n; ++x) {
//            if (bb.guess(x) == 0) {
//                return x;
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {
        Blackbox a = new Blackbox(100,40);
        System.out.println(a.secret);
        System.out.println(a.solve(a));
    }



}