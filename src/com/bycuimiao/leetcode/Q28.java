package com.bycuimiao.leetcode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @Date 2019-03-25 22:20
 * @Author bycuimiao
 **/
public class Q28 {
    public static void main(String[] args) {
        //String haystack = "hello", needle = "ll";
        String haystack = "wawww", needle = "www";
        System.out.println(strStr(haystack,needle));
    }

    /**
     * 执行用时 : 7 ms, 在Implement strStr()的Java提交中击败了57.74% 的用户
     * 内存消耗 : 37.2 MB, 在Implement strStr()的Java提交中击败了0.93% 的用户
     */
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.equals("")){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        for(int i = 0 ; i < a.length - b.length + 1 ; i ++){
            if(a[i] == b[0] && a.length - i >= b.length){
                boolean flag = true;
                for(int j = 1 ; j < b.length ; j ++){
                    if(a[i+j] != b[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}
