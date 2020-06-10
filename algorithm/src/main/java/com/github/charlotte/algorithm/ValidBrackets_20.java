package com.github.charlotte.algorithm;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidBrackets_20 {
    public static void main(String[] args) {
        System.out.println(new ValidBrackets_20().isValid("()"));
    }

    public boolean isValid(String s) {

        Node head = new Node();
        for (char each : s.toCharArray()) {
            head = putOrPop(head, each);
        }

        return head.next == null;
    }

    public Node putOrPop(Node head, char value) {
        char reflectionValue;
        switch (value) {
            case ')':
                reflectionValue = '(';break;
            case '}':
                reflectionValue = '{';break;
            case ']':
                reflectionValue = '[';break;
            default:
                reflectionValue = ' ';
        }
        if (head.value == reflectionValue) {
            return head.next;
        } else {
            return new Node(head, value);
        }
    }

    private class Node {
        Node next;
        char value;

        public Node() {

        }

        public Node(Node next, char value) {
            this.next = next;
            this.value = value;
        }
    }
}
