package com.github.charlotte.algorithm;

class Solution25 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode curr = head;
//        int n = 0;
//        while (curr!=null&&n!=k){
//            curr = curr.next;
//            n++;
//        }
//        if(n==k) {
//            curr = reverseKGroup(curr, k);
//            while (n-->0){
//                ListNode next = head.next;
//                head.next = curr;
//                curr = head;
//                head = next;
//            }
//            head = curr;
//        }
//        return head;
//    }
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return head;
    ListNode a =head, b = head;

    for (int i = 1; i <= k; i++) {
        if (b.next == null && i != k) {
            return a;
        }
        b = b.next;
    }

    ListNode newHead = reverse(a, b);
    a.next = reverseKGroup(b,k);
    return newHead;
}

    public ListNode reverse(ListNode a, ListNode b) {
        System.out.println("fuck");
        ListNode pre = null, cur = a;
        while (a != b) {
            cur = a;
            a = a.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
//        ListNode pre, cur, nxt;
//        pre = null; cur = a; nxt = a;
//        // while 终止的条件改一下就行了
//        while (cur != b) {
//            nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//        // 返回反转后的头结点
//        return pre;
    }

}