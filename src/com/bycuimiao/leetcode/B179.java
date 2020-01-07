package com.bycuimiao.leetcode;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/1/7 9:01 下午
 * @Author bycuimiao
 **/
public class B179 {

    public static void main(String[] args) {
        B179 obj = new B179();
        //[999999998,999999997,999999999]
        //[128,12,320,32]
        //[3,30,34,5,9]
        int[] nums = {128,12,320,32};
        String ans = obj.largestNumber(nums);
        System.out.println(ans);
    }
    public String largestNumber(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            int max = getMaxNum(nums[i]);
            if(map.containsKey(max)){
                List<Integer> list = map.get(max);
                list.add(nums[i]);
                map.put(getMaxNum(nums[i]),list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(getMaxNum(nums[i]),list);
            }
        }
        String ans = "";
        for(int i = 9 ; i >= 0 ; i --) {
            if(map.containsKey(i)){
                List<Integer> list = sortList(map.get(i),i);
                for(int j = 0 ; j < list.size() ; j ++){
                    ans = ans + list.get(j);
                }
            }
        }
        if(ans.substring(0,1).equals("0")){
            return "0";
        }
        return ans;
    }

    public List<Integer> sortList(List<Integer> list , int rule){
        Integer[] arr = list.toArray(new Integer[0]);
        int t;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //if (String.valueOf(arr[i]).indexOf(rule) > String.valueOf(arr[j]).indexOf(rule)) {
                if (compareNum(String.valueOf(arr[i]),String.valueOf(arr[j]),String.valueOf(rule))) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return Arrays.asList(arr);
    }

    //true是交换
    public boolean compareNum(String a , String b , String rule){
        String r1 = a + b;
        String r2 = b + a;
        for(int i = 0 ; i < r1.length(); i ++){
            if(Integer.parseInt(r1.substring(i,i+1)) > Integer.parseInt(r2.substring(i,i+1))){
                return false;
            }else if (Integer.parseInt(r1.substring(i,i+1)) < Integer.parseInt(r2.substring(i,i+1))){
                return true;
            }
        }
        return false;
        /*if(Integer.parseInt(a+b) > Integer.parseInt(b+a)){
            return false;
        }
        return true;*/
        /*if(a.indexOf(rule) > b.indexOf(rule)){
            return true;
        }else if(a.indexOf(rule) == b.indexOf(rule)){
            for(int i = 0 ; i < Math.min(a.length(),b.length()) ; i ++){
                if(Integer.parseInt(a.substring(i,i+1)) > Integer.parseInt(b.substring(i,i+1))){
                    return false;
                }else if(Integer.parseInt(a.substring(i,i+1)) < Integer.parseInt(b.substring(i,i+1))){
                    return true;
                }
            }
            if(a.length() > b.length()){
                for(int j = 0 ; j < b.length() ; j ++){
                    if(Integer.parseInt(b.substring(j,j+1)) > Integer.parseInt(a.substring(1,2))){

                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }*/
    }

    private static void bubblingSort(int[] arr) {
        int t;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public Integer getMaxNum(Integer num){
        //int max = Integer.MIN_VALUE;
        //char[] chars = String.valueOf(num).toCharArray();
        //Arrays.sort(chars);
        /*for(int i = 0 ; i < chars.length ; i ++) {
            int a = charToInt(chars[i]);
            if(a > max){
                max = a;
            }
        }*/
        return Integer.parseInt(String.valueOf(num).substring(0,1));
    }

    public Integer charToInt(char c){
        return c - '0';
    }
}
