package com.github.charlotte.algorithm.linkedlist;//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_234 {

    //    /**
//     * o(n)
//     */
//    ListNode begin;
//    public boolean isPalindrome(ListNode head) {
//        begin = head;
//        return traverse(head);
//    }
//
//    public boolean traverse(ListNode head) {
//        if(head==null){
//            return true;
//        }
//        boolean res = traverse(head.next);
//        int a = begin.val;
//        begin = begin.next;
//        return res && head.val==a;
//    }
    public boolean isPalindrome(ListNode head) {
        //快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
//        System.out.println(slow.val+"-"+fast.val);
        
        slow = reverse(slow);
        fast = head;
//        System.out.println(slow.val+"-"+fast.val);
        while (slow != null) {
            System.out.println(slow.val+"-"+fast.val);
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (head != null) {
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
