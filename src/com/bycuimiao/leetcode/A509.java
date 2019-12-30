package com.bycuimiao.leetcode;

/**
 * @Description
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/30 11:19 下午
 * @Author bycuimiao
 **/
public class A509 {
    public int fib(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        return fib(N-1 ) + fib(N-2);
    }

    public static void main(String[] args) {
        A509 obj = new A509();
        System.out.println(obj.fib(2));
        System.out.println(obj.fib(3));
        System.out.println(obj.fib(4));
        System.out.println(obj.fib(5));
        System.out.println(obj.fib(6));
    }
}
