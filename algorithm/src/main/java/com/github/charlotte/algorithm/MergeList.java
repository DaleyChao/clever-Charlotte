package com.github.charlotte.algorithm;

import java.util.LinkedList;
import java.util.List;

public class MergeList {
    List<Integer> merge(List<List<Integer>> list) {
        List<Integer> result = new LinkedList<>();
        for (; list.size() > 0; ) {
            int index = 0;
            int min = list.get(index).get(0);
            int tmp;
            for (index =0; index < list.size(); index++) {
                if (min > (tmp = list.get(index).get(0))) {
                    min = tmp;
                    result.add(min);
                    List inner = list.get(index);
                    inner.remove(0);
                    if(inner.size()==0){
                        list.remove(index);
                    }
                    break;
                }
                if(index == list.size()-1){
                    result.add(min);
                    List inner = list.get(0);
                    inner.remove(0);
                    if(inner.size()==0){
                        list.remove(0);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new LinkedList<>();
        List<Integer> b = new LinkedList<Integer>( );
        b.add(1);
        b.add(8);
        a.add(b);
        List<Integer> c = new LinkedList<Integer>( );
        c.add(2);
        c.add(4);
        a.add(c);
        List<Integer> d = new LinkedList<Integer>( );
        d.add(5);
        d.add(6);
        a.add(d);
        System.out.println(new MergeList().merge(a));
    }
}
