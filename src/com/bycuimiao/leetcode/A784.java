package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/14 8:10 下午
 * @Author bycuimiao
 **/
public class A784 {
    public List<String> letterCasePermutation(String s) {
        if(s.length() == 0){
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        if(s.length() == 1){
            if(isAlphabet(chars[0])){
                List<String> list = new ArrayList<>();
                list.add(s);
                list.add(String.valueOf(changeAlphabet(chars[0])));
                return list;
            }
        }

        List<String> res = new ArrayList<>();
        back(0,chars,new int[chars.length],res);
        return res;
    }

    public void back(int n , char[] chars , int[] flags,List<String> resList){
        if(n >= chars.length){
            /*for(int i = 0 ; i < resList.size() ; i ++){
                if(resList.get(i).equals(charsToString(chars))){
                    return;
                }
            }*/
            resList.add(charsToString(chars));
            return ;
        }
        back(n+1,chars,flags,resList);
        if(isAlphabet(chars[n])){
            chars[n] = changeAlphabet(chars[n]);
            back(n + 1,chars,flags,resList);
        }
    }

    public char changeAlphabet(char c){
        if(c >= 'a' && c <='z'){
            return (char)(c - ('a' - 'A'));
        }else {
            return (char)(c + ('a' - 'A'));
        }
    }

    public boolean isAlphabet(char c){
        return (c >= 'a' && c <='z') || (c >= 'A' && c <='Z');
        //return (c >= 'a' && c <='z') ;
    }

    public String charsToString(char[] chars){
        String str = "";
        for(int i = 0 ; i < chars.length ; i ++){
            str = str + chars[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "ab";
        A784 obj = new A784();
        List<String> list = obj.letterCasePermutation(s);
        list.forEach(System.out::println);
        /*char a = 'a';
        char A = 'A';
        System.out.println(A-a);
        System.out.println((int)'a');
        System.out.println((int)'A');*/
    }
}
