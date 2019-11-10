package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/10 5:53 下午
 * @Author bycuimiao
 **/
public class AQ125 {
    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 java 提交中击败了
     * 92.24%
     * 的用户
     * 内存消耗 :
     * 37.6 MB
     * , 在所有 java 提交中击败了
     * 91.03%
     * 的用户
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s.equals("")){
            return true;
        }
        int i = 0 , j = s.length()-1 ;
        char[] chars = s.toCharArray();
        while (i < j){
            if(!isAlphabet(chars[i]) && !isNum(chars[i])) {
                i ++;
                continue;
            }
            if(!isAlphabet(chars[j]) && !isNum(chars[j])) {
                j --;
                continue;
            }
            if( (isAlphabet(chars[i]) && isNum(chars[j])) || (isAlphabet(chars[j]) && isNum(chars[i])) ){
                return false;
            }
            if(chars[i] == chars[j] || Math.abs(chars[i] - chars[j]) == 32){
                i ++;
                j --;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isAlphabet(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        AQ125 obj = new AQ125();
        String s = "race a car";
        System.out.println(obj.isPalindrome(s));
    }
}
