package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/24 11:00 下午
 * @Author bycuimiao
 **/
public class B29W {
    /**
     * 超时
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        int dividendAbs = toNegative(dividend);
        int divisorAbs = toNegative(divisor);
        int res = 0;
        while (dividendAbs <= divisorAbs){
            dividendAbs = dividendAbs - divisorAbs;
            res --;
        }
        if( (dividend >0 && divisor > 0) || (dividend < 0 && divisor < 0) ){
            if(res == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -res;
        }else {
            return res;
        }
    }

    public int toNegative(int num){
        if(num <= 0){
            return num;
        }
        return -num;
    }

    public static void main(String[] args) {
        B29W obj = new B29W();
        /**
         * -2147483648
         * -1
         */
        /**
         * -2147483648
         * 1
         */
        System.out.println(obj.divide(-2147483648,-1));
        System.out.println(obj.divide(-2147483648,1));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(obj.divide(7,-3));
        System.out.println(obj.divide(0,-3));
        System.out.println(obj.divide(2,-10));
        //System.out.println(2/-10);
    }

}
