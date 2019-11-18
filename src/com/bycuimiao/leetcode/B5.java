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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-11-18 19:38
 */
public class B5 {
    /**
     * 速度还是比较慢
     * 989 ms	38.7 MB
     * 官方答案
     * 8 ms	36.1 MB
     * 差距就在于，在官方答案是计算出最长回文串的index，最后截取，而我这个是拼接出来最大串。。。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        String ans = String.valueOf(chars[0]);
        String tmp1 = "";
        String tmp2 = "";

        for(int i = 0 ; i < chars.length; i ++){
            tmp1 = huiwen1(chars,i);
            if(tmp1.length() > ans.length()){
                ans = tmp1;
            }
            tmp2 = huiwen2(chars,i);
            if(tmp2.length() > ans.length()){
                ans = tmp2;
            }
        }
        return ans;
    }

    public String huiwen1(char[] chars , int i){
        if(chars.length == 0){
            return "";
        }
        if(chars.length == 1){
            return String.valueOf(chars[0]);
        }
        String tmp1 = "";
        int j = i + 1;
        while (i < chars.length - 1 && i >=0 && j < chars.length && chars[i] == chars[j]){
            tmp1 = chars[i] + tmp1 + chars[j];
            i--;
            j++;
        }
        return tmp1;
    }

    public String huiwen2(char[] chars , int i){
        if(chars.length == 0){
            return "";
        }
        if(chars.length == 1){
            return String.valueOf(chars[0]);
        }
        if(i < 1){
            return "";
        }
        String tmp2 = "";
        int j = i + 1;
        i = i - 1;
        boolean flag = true;
        while (i >=0 && i < chars.length && j < chars.length && chars[i] == chars[j]){
            if(flag){
                tmp2 = String.valueOf(chars[i+1]);
                flag = false;
            }
            tmp2 = chars[i] + tmp2 + chars[j];
            i--;
            j++;
        }
        return tmp2;
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
        B5 obj = new B5();
        String s = "abacdfgdcaba";
        String res = obj.longestPalindrome(s);
        System.out.println(res);

        //System.out.println(obj.isHuiwen(s));
        //System.out.println(obj.huiwen2(s.toCharArray(),3));
    }
}
