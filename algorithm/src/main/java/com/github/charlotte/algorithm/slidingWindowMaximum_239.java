package com.github.charlotte.algorithm;

public class slidingWindowMaximum_239 {
    public static void main(String[] args) {
        for (int each:new slidingWindowMaximum_239().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)){
            System.out.print(each+" ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            putIntoQueue(result,k,i,nums);
        }
        return result;
    }

    Node tail=null;
    Node head = null;

    public void putIntoQueue(int[] result,int k,int i,int[] nums){
        if(head==null){
            head = new Node();
            head.value = i;
            tail = head;
            return;
        }

        if(i>(nums.length+1-k)){
            checkAndPop(tail,k,i,result,nums);
            result[i]=nums[head.value];
        }else {
            checkAndPop(tail,k,i,result,nums);
        }

    }

    public void checkAndPop(Node tail,int k,int i,int [] result,int [] nums){
        //i>k-1 检查范围
        if(head.value>=(i+1-k)){
            if(nums[tail.value]>nums[i]){
                Node tmp = new Node(null,tail,i);
                tail.next = tmp;
                tmp.pre = tail;
                tail = tmp;
//                if(head.value ==(i-k)){
//                }
                result[i+1-k] = nums[head.value];
            }else {
//                if(head.value == i){
//                    if(i>(k-1)){
//                        result[i - k] = nums[head.value];
//                    }
//                }
//                if(tail==head){
////                    tail = new Node(null,head,i]);
//                    head.value = i;
//                }else {
                    Node tmp = tail;
                    tail = tail.pre;
                    tmp = null;

                    checkAndPop(tail, k, i, result, nums);
//                }
            }

        }else {
            result[i-k] = nums[head.value];
            Node tmp = head;
            head = head.next;
            head.pre = null;
            tmp = null;



            checkAndPop(tail, k, i, result, nums);
        }

        //是否小雨  小雨删除继续递归

        //返回头

        //超出范围 删除头
    }

    private class Node{
        Node next;
        Node pre;
        int value ;
        Node(){

        }
        Node(Node next,Node pre,int value){
            this.next = next;
            this.pre = pre;
            this.value = value;
        }
    }
}
