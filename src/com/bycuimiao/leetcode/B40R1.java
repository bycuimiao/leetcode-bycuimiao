package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Date 2019/11/16 10:52 下午
 * @Author bycuimiao
 **/
public class B40R1 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,new ArrayList<>());
        return resList;
    }

    public void backtrack(int start , int[] candidates , int target ,int sum , List<Integer> res){
        if(sum == target){
            resList.add(new ArrayList<>(res));
            return;
        }
        if(sum > target){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = start ; i < candidates.length; i ++){
            if(!set.contains(candidates[i])){
                set.add(candidates[i]);
                sum = sum + candidates[i];
                res.add(candidates[i]);
            }else {
                continue;
            }

            backtrack(i + 1, candidates,target,sum,res);
            sum = sum - candidates[i];
            res.remove(res.size()-1);
            //map.remove(String.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
        int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        B40R1 obj = new B40R1();
        System.out.println(System.currentTimeMillis());
        List<List<Integer>> lists = obj.combinationSum2(candidates,target);
        System.out.println(System.currentTimeMillis());
        for(int i = 0 ; i < lists.size() ; i ++){
            String input = "[";
            for(int j = 0 ; j < lists.get(i).size() ; j ++){
                input = input + lists.get(i).get(j) + ",";
            }
            input = input + "]";
            System.out.println(input);
        }
    }
}
