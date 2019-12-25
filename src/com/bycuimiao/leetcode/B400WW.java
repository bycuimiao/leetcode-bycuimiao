package com.bycuimiao.leetcode;

/**
 * @Description
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 *
 * 示例 1:
 *
 * 输入:
 * 3
 *
 * 输出:
 * 3
 * 示例 2:
 *
 * 输入:
 * 11
 *
 * 输出:
 * 0
 *
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/25 9:54 下午
 * @Author bycuimiao
 **/
public class B400WW {

    public int findNthDigit(int n) {
        if(n < 10){
            return n;
        }
        int num = 1;
        int times = 1;
        while (times < n){
            // 几位数
            String numStr = String.valueOf(num);
            char[] chars = numStr.toCharArray();
            for(int i = 0 ; i < chars.length ; i ++){
                times ++;
                if(times == n){
                    return chars[i] - '0';
                }
            }
            num ++;
        }
        return 0;
    }

    /**
     * 输入:
     * 10000000
     * 输出
     * 3
     * 预期结果
     * 7
     * 错了。。。马丹
     * @param n
     * @return
     */
    public int findNthDigit1(int n) {
        if(n < 10){
            return n;
        }
        int num = 1;
        int times = 1;
        while (times < n){
            // 几位数
            int a = getWei(num);
            times = times + a;
            num ++;
        }
        int offset = times - n;
        if(offset != 0){
            num --;
        }
        int res = Integer.valueOf(String.valueOf(num).substring(offset,offset+1));
        return res;
    }

    // 返回n是几位数
    public int getWei(int n){
        int res = 0;
        while (n != 0){
            n = n / 10;
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        B400WW obj = new B400WW();
        /*for(int i = 1 ; i < 100 ; i ++){
            System.out.println(i + " - " + obj.findNthDigit(i));
        }*/
        //System.out.println('1' - '0');
        //System.out.println(obj.findNthDigit(Integer.MAX_VALUE));
        System.out.println(obj.findNthDigit(10));
    }
}
