package com.bycuimiao.leetcode;

/**
 * @Description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/18 9:24 下午
 * @Author bycuimiao
 **/
public class B2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        //res.next = new ListNode(0);
        ListNode head = res;
        int jinwei = 0;
        while (l1 != null || l2 != null){
            int a = 0;
            if(l1 != null){
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + jinwei;
            jinwei = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
        if(jinwei != 0){
            head.next = new ListNode(jinwei);
        }
        return res.next;
    }

    public static void main(String[] args) {
        B2 obj = new B2();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = obj.addTwoNumbers(l1,l2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
