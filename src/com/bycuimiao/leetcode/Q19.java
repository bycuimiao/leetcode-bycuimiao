package com.bycuimiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * @Date 2019-03-28 11:16
 * @Author bycuimiao
 **/
public class Q19 {
    public  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer,ListNode> m = new HashMap<Integer,ListNode>();
        int index=1;
        while(temp!=null){
            m.put(index++,temp);
            temp = temp.next;
        }
        int size = m.size();
        if(size == 1)
            return null;
        if(n == 1){
            m.get(size-1).next = null;
        }else if(n == size){
            head = head.next;
        }else{
            m.get(size-n).next = m.get(size-n+2);
        }
        return head;
    }

    /**
     * 执行用时 : 17 ms, 在Remove Nth Node From End of List的Java提交中击败了15.13% 的用户
     * 内存消耗 : 39.4 MB, 在Remove Nth Node From End of List的Java提交中击败了0.96% 的用户
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode l1 = preHead;
        ListNode l2 = preHead;
        while(n > 0){
            l1 = l1.next;
            n--;
        }
        while(l1.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        //l2的下一个结点就是倒数第n个
        l2.next = l2.next.next;
        return preHead.next;
    }

    /**
     * 执行用时 : 15 ms, 在Remove Nth Node From End of List的Java提交中击败了69.42% 的用户
     * 内存消耗 : 40.1 MB, 在Remove Nth Node From End of List的Java提交中击败了0.96% 的用户
     *
     * 时间复杂度：O(L)O(L)，
     * 该算法对含有 LL 个结点的列表进行了一次遍历。因此时间复杂度为 O(L)O(L)。
     * 空间复杂度：O(1)O(1)，
     * 我们只用了常量级的额外空间
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
