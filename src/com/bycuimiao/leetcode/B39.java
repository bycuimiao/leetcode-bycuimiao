package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/16 9:52 下午
 * @Author bycuimiao
 **/
public class B39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        back(0,0,candidates,target,new ArrayList<>(),resList);
        return resList;
    }

    public void back(int pos ,int sum ,int[] candidates, int target ,List<Integer> res , List<List<Integer>> resList){
        if(sum == target){
            resList.add(new ArrayList<>(res));
            return;
        }
        if(sum > target){
            //剪枝
            return;
        }
        for(int i = 0 ; i < candidates.length ; i ++){
            if(res.size() > 0 && res.get(res.size()-1) > candidates[i]){
                //剪枝
                continue;
            }
            res.add(candidates[i]);
            sum = sum + candidates[i];
            back(pos +1 ,sum,candidates,target,res,resList);
            sum = sum - candidates[i];
            res.remove(res.size()-1);
        }

    }

    public static void main(String[] args) {
        //candidates = [2,3,6,7], target = 7,
        int[] candidates = {2,3,5};
        int target = 8;
        B39 obj = new B39();
        List<List<Integer>> lists = obj.combinationSum(candidates,target);
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
