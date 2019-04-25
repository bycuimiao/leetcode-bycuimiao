package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miao.cui
 * @description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @date 2019-04-25 11:08
 */
public class Q78 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }

    /**
     * 这个题蛮有意思的，可以直接从后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     * 执行用时 : 2 ms, 在Subsets的Java提交中击败了92.92% 的用户
     * 内存消耗 : 36.6 MB, 在Subsets的Java提交中击败了48.50% 的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length ; i ++){
            int size = res.size();
            for(int j = 0 ; j < size ; j ++){
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
