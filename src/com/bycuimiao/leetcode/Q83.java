package com.bycuimiao.leetcode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @Date 2019-04-03 09:22
 * @Author bycuimiao
 **/
public class Q83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head = deleteDuplicates(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;

        }
    }

    /**
     * 执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了36.66% 的用户
     * 内存消耗 : 36.6 MB, 在Remove Duplicates from Sorted List的Java提交中击败了1.00% 的用户
     * 时间复杂度：O(n)O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)O(n)，其中 nn 是列表中的结点数。
     * 空间复杂度：O(1)O(1)，没有使用额外的空间。
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 错误写法，会丢失第一个元素
     *
     * 错误用例 ： [1,1,2]
     */
    /*public static ListNode deleteDuplicates2(ListNode head) {
        while (head != null && head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return head;
    }*/
}
