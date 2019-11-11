package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * AQ155
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/11 9:19 下午
 * @Author bycuimiao
 **/
public class MinStack {
    /** initialize your data structure here. */
    //数组的长度
    int len = 10;
    //初始化的数组
    int[] arr = new int[len];
    //初始化list
    //List<Integer> list = new ArrayList<>();
    //指针
    int cur = -1;

    public MinStack() {

    }

    public void push(int x) {
        if(cur < len - 1){
            //可以进行push操作
            for(int i = cur ; i >= 0 ; i --){
                arr[i+1] = arr[i];
            }
            arr[0] = x;
            cur ++;
        }else {
            //需要进行扩容操作,并同时完成push
            len = len*2;
            int[] arr2 = new int[len];
            arr2[0] = x;
            //因为此刻是满栈状态，所以 arr.length 等于 cur
            for(int i = 0 ; i < arr.length ; i ++){
                arr2[i+1] = arr[i];
            }
            arr = arr2;
            cur ++;
        }
    }

    public void pop() {
        if(cur > -1){
            //有数据，可以进行弹栈。注意:这里不是 <=
            for(int i = 0 ; i < cur ; i ++){
                arr[i] = arr[i+1];
            }
            cur --;
        }
    }

    public int top() {
        if(cur > -1){
            return arr[0];
        }
        return -1;
    }

    /**
     * 这里其实是不符合题意的，时间复杂度并不是O(1)
     * @return
     */
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= cur ; i ++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    /**
     * 执行用时 :
     * 247 ms
     * , 在所有 java 提交中击败了
     * 7.93%
     * 的用户
     * 内存消耗 :
     * 56.7 MB
     * , 在所有 java 提交中击败了
     * 10.84%
     * 的用户
     */
}
