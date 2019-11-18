package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-11-18 19:09
 */
public class B3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        String ans = String.valueOf(chars[0]);
        for(int i = 1 ; i < chars.length ; i ++){
            if(ans.contains(String.valueOf(chars[i]))){
                ans = ans.substring(ans.indexOf(chars[i])+1) + chars[i];
            }else {
                ans = ans + chars[i];
                if(ans.length() > max){
                    max = ans.length();
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        B3 obj = new B3();
        String s = "pwwkew";
        int n = obj.lengthOfLongestSubstring(s);
        System.out.println(n);
    }
}
