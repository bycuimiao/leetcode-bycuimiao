package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/16 7:25 下午
 * @Author bycuimiao
 **/
public class B22 {
    /**
     * 预料之内，，，超时了
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        //int[] flags = new int[n];
        //back(0,n,0,flags,"",list);
        String str = "";
        for(int i = 0 ; i < n; i ++){
            str = str + "()";
        }
        //str = "abcd";
        char[] chars = str.toCharArray();
        //装着全部括号的字符串集合
        String[] strs = new String[chars.length];
        for(int i = 0 ; i < chars.length ; i ++){
            strs[i] = String.valueOf(chars[i]);
        }
        int[] flags = new int[strs.length];
        back(0,strs,flags,"",list);
        return list;
    }

    void back(int first , String[] strs , int[] flags, String res ,List<String> resList){
        if(res.length() == strs.length){
            if(!isHave(resList,res)){
                resList.add(res);
            }
            return;
        }
        for(int i = 0 ; i < strs.length ; i ++){
            if(isWrong(res,strs[i])){
                //break;//剪枝
                continue;
            }
            if(flags[i] == 0){
                res = res + strs[i];
                flags[i] = 1;
            }else {
                continue;
            }
            back(i + 1 , strs , flags,res , resList);
            res = res.substring(0,res.length()-1);
            flags[i] = 0;
        }
    }

    boolean isHave(List<String> resList , String res){
        for(String str : resList){
            if(res.equals(str)){
                return true;
            }
        }
        return false;
    }

    boolean isWrong(String res , String str){
        int a = 0;
        int b = 0;
        char[] chars = res.toCharArray();
        for(int i = 0 ; i < chars.length ; i ++){
            if(chars[i] == '('){
                a ++;
            }else {
                b++;
            }
        }
        if(str.equals("(")){
            a ++;
        }else {
            b ++;
        }
        if(b > a){
            //括号)数量，多于括号(的数量，不合法
            return true;
        }
        return false;
    }

    void back02(int first , int n ,int m,int[] flags, String res ,List<String> resList){
        if(n*2 == res.length()){
            resList.add(res);
            return;
        }
        for(int i = first ; i < n * 2 ; i ++){
            if(flags[m] == 0){
                res = res + "(";
                flags[m] = 1;
            }else {
                res = res + ")";
                m ++;
            }
            back02(i + 1 ,n,m,flags,res , resList);

        }
    }

    public static void main(String[] args) {
        B22 obj = new B22();
        int n = 3;
        List<String> list = obj.generateParenthesis(n);
        list.forEach(System.out::println);
    }



}
