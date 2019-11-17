package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/17 9:23 上午
 * @Author bycuimiao
 **/
public class B77 {
    public List<List<Integer>> combine(int n, int k) {
        if(k > n){
            return new ArrayList<>();
        }
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i ++){
            nums[i] = i +1;
        }
        List<List<Integer>> resList = new ArrayList<>();
        back(nums,k,0,new ArrayList<>(),resList);
        return resList;
    }

    void back(int[] nums , int k ,int start, List<Integer> res , List<List<Integer>> resList){
        if(res.size() == k){
            resList.add(new ArrayList<>(res));
        }
        for(int i = start ; i < nums.length ; i ++){
            if(res.size() > k){
                break;
            }
            res.add(nums[i]);
            back(nums,k,i + 1,res,resList);
            res.remove(res.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        B77 obj = new B77();
        List<List<Integer>> lists = obj.combine(n,k);
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
