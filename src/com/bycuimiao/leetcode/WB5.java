package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 没弄出来，回头再看吧
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-11-18 19:38
 */
public class WB5 {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        String ans = String.valueOf(chars[0]);
        String tmp = String.valueOf(chars[0]);

        for(int i = 0 ; i < chars.length ; i ++){
            if(isHuiwen(tmp)){
                if(tmp.length() > ans.length()){
                    ans = tmp;
                }
            }else {
                tmp = tmp + chars[i];
            }
        }
        return ans;
    }

    public boolean isHuiwen(String s){
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length/2 + 1 ; i ++){
            if(chars[i] == chars[chars.length-1-i]){
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WB5 obj = new WB5();
        String s = "abba";
        String res = obj.longestPalindrome(s);
        System.out.println(res);

        System.out.println(obj.isHuiwen(s));
    }
}
