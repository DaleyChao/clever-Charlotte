package com.github.charlotte.algorithm;

class Solution1 {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char temp ;
        while (i < j) {
             temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char i : s
        ) {
            System.out.print(i);
        }
    }
}