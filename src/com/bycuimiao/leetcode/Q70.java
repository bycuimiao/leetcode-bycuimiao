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
        System.out.println(climbStairs3(5));
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


    /**
     * 执行用时 : 0 ms, 在Climbing Stairs的Java提交中击败了100.00% 的用户
     * 内存消耗 : 32 MB, 在Climbing Stairs的Java提交中击败了0.71% 的用户
     * 时间复杂度：O(n)O(n) 。树形递归的大小可以达到 nn 。
     * 空间复杂度：O(n)O(n) 。递归树的深度可以达到 nn 。
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs33(0, n, memo);
    }
    public static int climb_Stairs33(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs33(i + 1, n, memo) + climb_Stairs33(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 动态规划
     * 执行用时 : 0 ms, 在Climbing Stairs的Java提交中击败了100.00% 的用户
     * 内存消耗 : 32.5 MB, 在Climbing Stairs的Java提交中击败了0.71% 的用户
     * 时间复杂度：O(n)，单循环到 n 。
     * 空间复杂度：O(n)。dpdp 数组用了 n 的空间。
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 执行用时 : 0 ms, 在Climbing Stairs的Java提交中击败了100.00% 的用户
     * 内存消耗 : 32.1 MB, 在Climbing Stairs的Java提交中击败了0.71% 的用户
     * 时间复杂度：O(n)。单循环到 n，需要计算第 n 个斐波那契数。
     * 空间复杂度：O(1)。使用常量级空间。
     *
     * 在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     *
     * Fib(n)=Fib(n-1)+Fib(n-2) Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 11 和 22 作为第一项和第二项的斐波那契数列中的第 nn 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     * @param n
     * @return
     */
    public int climbStairs5(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
