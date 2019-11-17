package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/16 10:21 下午
 * @Author bycuimiao
 **/
public class B40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        Map<String,Boolean> map = new HashMap<>();
        back(0,0,new boolean[candidates.length],candidates,target,new ArrayList<>(),resList ,map);
        return resList;
    }

    public void back(int pos ,int sum ,boolean[] used,int[] candidates, int target ,List<Integer> res , List<List<Integer>> resList,Map<String,Boolean> map){
        if(sum == target){
            if(!isHave(map,res)){
                resList.add(new ArrayList<>(res));
            }
            return;
        }
        if(sum > target){
            //剪枝
            return;
        }
        for(int i = 0 ; i < candidates.length ; i ++){
            if(i > 0 && candidates[i-1]==candidates[i] && used[i-1] ){
                //剪枝
                //used[i] = true;
                continue;
            }
            if(res.size() > 0 && res.get(res.size()-1) > candidates[i]){
                //剪枝
                continue;
            }
            if(!used[i]){
                res.add(candidates[i]);
                sum = sum + candidates[i];
                used[i] = true;
            }else {
                continue;
            }
            back(pos +1 ,sum,used,candidates,target,res,resList,map);
            sum = sum - candidates[i];
            res.remove(res.size()-1);
            used[i] = false;
        }

    }


    public boolean isHave(Map<String,Boolean> map , List<Integer> res){
        String key = intToStr(res);
        if(map.get(key) == null){
            map.put(key,true);
            return false;
        }else {
            return true;
        }
    }

    public String intToStr(List<Integer> res){
        String str = "";
        for(int i = 0 ; i < res.size(); i ++){
            str = str + res.get(i);
        }
        return str;
    }

    public static void main(String[] args) {
        //candidates = [2,3,6,7], target = 7,
        int[] candidates = {1,1};
        int target = 1;
        B40 obj = new B40();
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
