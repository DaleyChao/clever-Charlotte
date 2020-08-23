package com.github.charlotte.lcn;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        for (int each :
                retainAll(new int[]{1, 3}, new int[]{1, 2, 3, 4, 5, 6, 7, 8})) {
            System.out.println(each);

        }
    }

    public static int[] retainAll(int[] array1, int[] array2) {
        int i = 0, j = 0;
        int length1 = array1.length;
        int length2 = array2.length;
        List<Integer> result = new ArrayList<>();
        int value1, value2;
        for (; i < length1 && j < length2; ) {

            //对比大小 小的一方index+1
            if ((value1 = array1[i]) == (value2 = array2[j])) {
                result.add(array1[i]);
                i++;
                j++;
            } else if (value1 < value2) {
                i++;
            } else {
                j++;
            }
        }

        //list转为基础类型数组
        int[] arrayResult = new int[(result.size())];
        for (int k = 0; k < result.size(); k++) {
            arrayResult[k] = result.get(k);
        }

        return arrayResult;
    }
}
