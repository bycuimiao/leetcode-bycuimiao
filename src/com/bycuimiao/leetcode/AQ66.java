package com.bycuimiao.leetcode;

import java.math.BigDecimal;

/**
 * @Description
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/8 9:31 下午
 * @Author bycuimiao
 **/
public class AQ66 {
    /**
     * 测试用例超过int范围
     * 测试用例long超过范围
     * 我擦，不能用BigDecimal，可以用，需要导入包。。。
     * 执行用时 :
     * 11 ms
     * , 在所有 java 提交中击败了
     * 51.15%
     * 的用户
     * 内存消耗 :
     * 36.5 MB
     * , 在所有 java 提交中击败了
     * 35.11%
     * 的用户
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        BigDecimal sum = BigDecimal.ZERO;
        for(int i = 0 ;i < digits.length ; i ++){
            BigDecimal t = BigDecimal.valueOf(digits[i]).multiply(BigDecimal.valueOf(10).pow((digits.length - 1 - i)));
            sum = sum.add(t);
        }
        sum = sum.add(BigDecimal.ONE);
        char[] chars = sum.toPlainString().toCharArray();
        int[] res = new int[chars.length];
        for(int i = 0 ; i < chars.length ; i ++){
            res[i] = chars[i] - '0';
        }
        return res;
    }


    /**
     * 优雅的解决方案。。。。
     * 卧槽！！！比我自己的方案优雅1000倍。。。
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        AQ66 obj = new AQ66();
        //[9,8,7,6,5,4,3,2,1,0]
        //[6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3]
        System.out.println("Integer.MAX_VALUE:"+Integer.MAX_VALUE);
        System.out.println("Long.MAX_VALUE:"+Long.MAX_VALUE);
        int[] digits = {9,4,9,9};
        int[] res = obj.plusOne2(digits);
        for(int i = 0 ; i < res.length ; i ++){
            System.out.println(res[i]);
        }
    }
}
