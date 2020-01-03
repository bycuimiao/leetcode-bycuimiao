package com.bycuimiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/1/3 10:26 下午
 * @Author bycuimiao
 **/
public class A13 {

    //ps: 使用substring每次都new新的字符串，内存消耗高，但耗时少。
    //    使用toCharArray只需要一次内存消耗，内存消耗少，但耗时高
    /**
     * 10 ms	37.1 MB
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        //char[] chars = s.toCharArray();
        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }


    /**
     * 13 ms	36.9 MB
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0 ; i < chars.length ; i ++){
            Integer t = null;
            if(i+1 < chars.length){
                t = map.get(String.valueOf(chars[i]) + String.valueOf(chars[i+1]));
            }
            if(t == null){
                t = map.get(String.valueOf(chars[i]));
            }else {
                i ++;
            }
            sum += t;
        }
        return sum;
    }

    public static void main(String[] args) {
        A13 obj = new A13();
        System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("IV"));
        System.out.println(obj.romanToInt("IX"));
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }
}
