package com.bycuimiao.leetcode;

/**
 * @Description
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @Date 2019/12/9 11:57 下午
 * @Author bycuimiao
 **/
public class A203 {

    public ListNode removeElements(ListNode head, int val) {
        /*定义一个哑节点*/
        ListNode dumb = new ListNode(0);
        /*定义一个节点赋值为哑节点*/
        dumb.next = head;
        /*定义一个遍历节点*/
        ListNode iter = dumb;
        /*当下个节点不为null时继续遍历*/
        while (iter.next != null) {
            //ListNode curr = iter.next;
            /*如果下个节点等于val值，则下个节点替换为下下个节点并立即进行下次迭代*/
            if (iter.next.val == val) {
                iter.next = iter.next.next;
                continue;
            }
            /*如果不相等，迭代节点向后移动一个*/
            iter = iter.next;
        }
        return dumb.next;
    }

    public static void main(String[] args) {
        A203 obj = new A203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode originHead = obj.removeElements(head,6);
        while (originHead != null){
            System.out.println(originHead.val);
            originHead = originHead.next;
        }
    }
}
