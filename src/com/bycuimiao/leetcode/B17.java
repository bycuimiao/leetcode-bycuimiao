package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @Date 2019/11/15 8:06 下午
 * @Author bycuimiao
 **/
public class B17 {
    private static Map<String,List<String>> map = new HashMap<>();
    static
    {
        map.put("2", new ArrayList<String>(Arrays.asList("a","b","c")));
        map.put("3", new ArrayList<String>(Arrays.asList("d","e","f")));
        map.put("4", new ArrayList<String>(Arrays.asList("g","h","i")));
        map.put("5", new ArrayList<String>(Arrays.asList("j","k","l")));
        map.put("6", new ArrayList<String>(Arrays.asList("m","n","o")));
        map.put("7", new ArrayList<String>(Arrays.asList("p","q","r","s")));
        map.put("8", new ArrayList<String>(Arrays.asList("t","u","v")));
        map.put("9", new ArrayList<String>(Arrays.asList("w","x","y","z")));
    }
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }
        String[] numStrs = splitNums(digits);
        /*for(int i = 0 ; i < strs.length ; i ++){
            map.get(strs[i]);
        }*/
        //这里是数字的全部组合形式
        List<String> numsList = new ArrayList<>();
        numsList.add(digits);
        //backNum(numStrs,new int[numStrs.length],"",numsList);
        List<String> resList = new ArrayList<>();
        for(int i = 0 ; i < numsList.size(); i ++){
            String[] nums = splitNums(numsList.get(i));
            back(0,nums,"",resList);
        }
        return resList;
    }

    public void back(int n , String[] nums , String res , List<String> resList){
        if(res.length() == nums.length){
            resList.add(res);
            return;
        }
        for(int i = n ; i < nums.length ; i ++){
            List<String> list = map.get(nums[i]);
            if(i !=0 && res.length() ==0){
                break;
            }
            for(int j = 0 ; j < list.size() ; j ++){
                res = res + list.get(j);
                back(i+1,nums,res,resList);
                res = res.substring(0,res.length()-1);
            }
        }
    }

    public void backNum(String[] numStrs ,int[] flags, String res, List<String> resList){
        if(res.length() == numStrs.length) {
            resList.add(res);
            return;
        }
        for(int i = 0 ; i < numStrs.length ; i ++){
            if(flags[i] == 0){
                res = res + numStrs[i];
            }else {
                continue;
            }
            flags[i] = 1;
            backNum(numStrs,flags,res,resList);
            flags[i] = 0;
            //i --;
            res = res.substring(0,res.length()-1);
        }
    }



    public String[] splitNums(String digits){
        char[] chars = digits.toCharArray();
        String[] strs = new String[chars.length];
        for(int i = 0 ; i < chars.length ; i ++){
            strs[i] = String.valueOf(chars[i]);
        }
        return strs;
    }

    public static void main(String[] args) {
        String nums = "234";
        B17 obj = new B17();
        List<String> strs = obj.letterCombinations(nums);
        strs.forEach(System.out::println);
    }
    /**
     * 马丹，想复杂了，日狗
     */
}
