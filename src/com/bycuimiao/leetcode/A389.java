package com.bycuimiao.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/26 11:12 下午
 * @Author bycuimiao
 **/
public class A389 {
    public char findTheDifference(String s, String t) {
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        char[] charsT = t.toCharArray();
        Arrays.sort(charsT);
        for(int i = 0 ; i < charsS.length ; i ++) {
            if(charsS[i] != charsT[i]) {
                return charsT[i];
            }
        }
        return charsT[charsT.length - 1];
    }

    public static void main(String[] args) {
        A389 obj = new A389();
        System.out.println(obj.findTheDifference("abc","abce"));
    }
}
