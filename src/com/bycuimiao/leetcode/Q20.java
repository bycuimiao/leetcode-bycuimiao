package com.bycuimiao.leetcode;


import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author bycuimiao
 */
public class Q20 {


    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
        System.out.println(isValid(s));
    }

    /**
     * 执行用时 : 13 ms, 在Valid Parentheses的Java提交中击败了35.54% 的用户
     * 内存消耗 : 35.6 MB, 在Valid Parentheses的Java提交中击败了2.40% 的用户
     */
    public static boolean isValid(String s) {
        if(s.trim().isEmpty()){
            return true;
        }
        //如果长度是1，则返回false
        if((s.length()&1)==1){
            return false;
        }
        Stack<Character> strstack=new Stack<>();
        HashMap<Character,Character> strmap=new HashMap<>();
        strmap.put(')','(');
        strmap.put(']','[');
        strmap.put('}','{');
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp==')'||temp=='}'||temp==']'){
                if(strstack.isEmpty()||strstack.pop()!=strmap.get(temp)){
                    return false;
                }
            }else{
                strstack.push(temp);
            }
        }
        if(strstack.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 感觉这是LeetCode的一个bug。。。
     * 这个居然通过不了，显示"{[]}"用例错误
     * @param s
     * @return
     */
    public static boolean isValid2(String s){
        String replace = s.replace("{}", "");
        replace =replace.replace("[]","");
        replace = replace.replace("()","");
        if(replace.equals("")){
            return true;
        }else{
            return false;
        }

    }
}
