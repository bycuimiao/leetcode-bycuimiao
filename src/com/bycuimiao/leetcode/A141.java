package com.bycuimiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/10 8:51 下午
 * @Author bycuimiao
 **/
public class A141 {
    /**
     * 显然，这不是常量的内存消耗
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if(head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head.next != null){
            if(set.contains(head.next)){
                return true;
            }
            set.add(head.next);
            head = head.next;
        }
        return false;
    }

    /**
     * 机智的双指针可以实现O(1)的空间复杂度
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 37.2 MB
     * , 在所有 java 提交中击败了
     * 97.02%
     * 的用户
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == null || fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 官方双指针 ps:没我的快，哈哈哈
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        A141 obj = new A141();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(obj.hasCycle(head));
    }
}
