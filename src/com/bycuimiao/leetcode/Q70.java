package com.bycuimiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @Date 2019-04-02 19:23
 * @Author bycuimiao
 **/
public class Q70 {

    public static void main(String[] args) {
        //ystem.out.println(myClimbStairs(5));
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(myClimbStairs2(5));
    }

    /**
     * error!
     * 超出时间限制！
     * @param n
     * @return
     */
    /*public static int myClimbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return myClimbStairs(n - 1) + myClimbStairs( n - 2);
    }*/

    /**
     * 执行用时 : 2 ms, 在Climbing Stairs的Java提交中击败了99.98% 的用户
     * 内存消耗 : 32.4 MB, 在Climbing Stairs的Java提交中击败了0.71% 的用户
     * @param n
     * @return
     */
    public static int myClimbStairs2(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        return myClimbStairs21(n,map);
    }
    public static int myClimbStairs21(int n , Map<Integer,Integer> map ) {
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }
            if(map.get(n) == null){
                int num = myClimbStairs21(n - 1,map) + myClimbStairs21( n - 2,map);
                map.put(n,num);
            }
            return map.get(n);
    }
}
