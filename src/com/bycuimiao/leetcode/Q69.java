package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description: 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * @date 2019-04-25 10:26
 */
public class Q69 {
    public static void main(String[] args) {
        System.out.println(newtonSqrt(8));
    }

    /**
     * 超出时间限制
     * 最后执行的输入：2147483647
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int result = x / 2;
        while (result * result < x) {
            result++;
        }
        if (result * result == x) {
            return result;
        }
        result--;
        return result;
    }

    //

    /**
     * 牛顿迭代法，最优解
     * 这个博客解释的很清楚 https://www.cnblogs.com/qlky/p/7735145.html
     * 执行用时 : 6 ms, 在Sqrt(x)的Java提交中击败了94.30% 的用户
     * 内存消耗 : 32.7 MB, 在Sqrt(x)的Java提交中击败了93.12% 的用户
     * 首先随便猜一个近似值res，然后不断令res等于res和x/res的平均数，迭代个六七次后x的值就已经相当精确了。
     * @param x
     * @return
     */
    public static int newtonSqrt(int x) {
        if (x <= 1) return x;
        double last = 0, res = 1;
        while (last != res) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    /**
     * 易于理解
     * 执行用时 : 7 ms, 在Sqrt(x)的Java提交中击败了80.96% 的用户
     * 内存消耗 : 33 MB, 在Sqrt(x)的Java提交中击败了84.30% 的用户
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (right >= left) {
            long mid = (left + right) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
