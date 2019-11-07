package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Date 2019/11/7 11:49 下午
 * @Author bycuimiao
 **/
public class B46R2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> res = new ArrayList<>();
        back(list,new Stack<>(),res);
        System.out.println(res);
    }

    private static void back(List<Integer> list , Stack<Integer> stack , List<List<Integer>> res){
        if(list.size() == stack.size()){
            res.add(new ArrayList<>(list));
        }
        for(int i = 0 ; i < list.size() ; i ++){
            if(stack.contains(list.get(i))){
                continue;
            }else {
                stack.push(list.get(i));
                back(list,stack,res);
                stack.pop();
            }
        }

    }
}
