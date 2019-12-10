package com.bycuimiao.leetcode;

import java.util.Stack;

/**
 * @Description
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/10 9:47 下午
 * @Author bycuimiao
 **/
public class A206 {
    public ListNode reverseList1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(0);
        ListNode dump = res;
        while (!stack.isEmpty()){
            dump.next = new ListNode(stack.pop());
            dump = dump.next;
        }
        return res.next;
    }

    /**
     * 时间复杂度：O(n)O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(1)O(1)。
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 时间复杂度：O(n)O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)O(n)。
     * 空间复杂度：O(n)O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层。
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        A206 obj = new A206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = obj.reverseList3(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
