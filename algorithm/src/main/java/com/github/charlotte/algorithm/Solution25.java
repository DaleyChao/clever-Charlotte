package com.github.charlotte.algorithm;

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int n = 0;
        while (curr!=null&&n!=k){
            curr = curr.next;
            n++;
        }
        if(n==k) {
            curr = reverseKGroup(curr, k);
            while (n-->0){
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}