package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/17 8:18 下午
 * @Author bycuimiao
 **/
public class A367 {
    /**
     * 426 ms	33 MB
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        for(int i = 1 ; i <= num/2 ; i ++){
            if(num == i * i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        A367 obj = new A367();
        boolean flag = obj.isPerfectSquare(9);
        System.out.println(flag);
    }
}
