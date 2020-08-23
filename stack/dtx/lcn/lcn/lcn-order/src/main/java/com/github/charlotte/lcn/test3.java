package com.github.charlotte.lcn;

import java.util.ArrayList;
import java.util.List;

public class test3 {

    public static void main(String[] args) {

            System.out.println(find(new char[]{'a','b','c','d','f','g'},new char[]{'a','b','c','d','f'}));


    }

    public static char find(char[] chars1, char[] chars2) {
        int i = 0;
        // o(n)复杂度
        for (; i < chars2.length; i++) {
            if (chars2[i] != chars1[i]) {
                return chars1[i];
            }
        }
        return chars1[i];

    }
}
