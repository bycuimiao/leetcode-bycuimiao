package com.bycuimiao.leetcode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @Date 2019-04-04 08:13
 * @Author bycuimiao
 **/
public class Q82 {
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
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next, sPre = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && pre.val != cur.val && cur.val == next.val) {
                sPre = pre;
                pre = cur;
                cur = next;
            } else if (pre.val == cur.val && (next == null || cur.val != next.val)) {
                sPre.next = next;
                pre = sPre;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead,cur=head;
        int count=1;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                count++;
            }else{
                if(count>1){
                    pre.next=cur.next;
                }else{
                    pre=pre.next;
                }
                count=1;
            }
            cur=cur.next;
        }
        if(count>1){
            pre.next=cur.next;
        }
        return dummyHead.next;
    }


    /**
     * 执行用时 : 2 ms, 在Remove Duplicates from Sorted List II的Java提交中击败了58.76% 的用户
     * 内存消耗 : 37.6 MB, 在Remove Duplicates from Sorted List II的Java提交中击败了0.60% 的用户
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head){
        if(head == null ||  head.next==null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (pre != null && cur != null && cur.next != null  ){
            if(cur.val == cur.next.val){
                while(cur != null && cur.next!=null && cur.val == cur.next.val)
                    cur = cur.next;
                //此时cur在这个数字的最后一个重复元素
                //此时pre的next结点指向下一个数字
                pre.next = cur.next;
                cur = pre.next;
                //此时pre先不移动  因为下一个数 可能还是重复数

            }else {
                //此时pre再移动
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
