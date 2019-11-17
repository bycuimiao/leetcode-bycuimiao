package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Date 2019/11/16 11:07 下午
 * @Author bycuimiao
 **/
public class B40R2 {
    List<List<Integer>> res = new ArrayList<>();
    public void backtrack(int[] nums , int start , int target , Stack<Integer> temp, int sum){

        HashSet hashSet = new HashSet();
        for(int i = start ; i < nums.length ; i ++){
            //剪枝1 同一个父节点的子节点必须是不同的值
            if(hashSet.contains(nums[i])){
                continue;
            }else{
                hashSet.add(nums[i]);
            }

            temp.push(nums[i]);
            sum += nums[i];

            //剪枝2 获取到目标,回溯
            if(sum == target){
                res.add(new ArrayList<>(temp));
//                这里可以再次剪枝 直接终止
//                temp.pop();
//                sum -= nums[i];
//                return;
            }else if(sum < target){
                backtrack(nums,i + 1 , target , temp , sum);
            }

            temp.pop();
            sum -= nums[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates , 0 , target , new Stack<Integer>() , 0);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        B40R2 obj = new B40R2();
        List<List<Integer>> lists = obj.combinationSum2(candidates,target);
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
