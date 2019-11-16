package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/16 8:45 下午
 * @Author bycuimiao
 **/
public class B47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        int[] flags = new int[nums.length];
        back(flags,nums,new ArrayList<>(),resList);
        return resList;
    }

    public void back(int[] flags ,int[] nums, List<Integer> res , List<List<Integer>> resList){
        if(res.size() == nums.length){
            resList.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0 ; i < nums.length ; i ++){
            //剪枝
            if (i > 0 && nums[i] == nums[i - 1] && flags[i - 1]==0) {
                continue;
            }
            if(flags[i] == 0){
                res.add(nums[i]);
                flags[i] = 1;
            }else {
                continue;
            }
            back(flags,nums,res,resList);
            res.remove(res.size()-1);
            flags[i] = 0;
        }
    }

    /*private static Map<String,Boolean> map ;
    static {
        map = new HashMap<>();
    }
    public boolean isHave(List<Integer> res){
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
    }*/

    public static void main(String[] args) {
        //[1,-1,1,2,-1,2,2,-1]
        int[] num = {1,1,2};
        B47 obj = new B47();
        List<List<Integer>> lists = obj.permuteUnique(num);
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
