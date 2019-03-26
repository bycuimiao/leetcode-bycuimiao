package com.bycuimiao.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Date 2019-03-26 10:18
 * @Author bycuimiao
 **/
public class Q53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 执行用时 : 16 ms, 在Maximum Subarray的Java提交中击败了57.99% 的用户
     * 内存消耗 : 43 MB, 在Maximum Subarray的Java提交中击败了1.20% 的用户
     * 用sum记录当前最大值，res记录最终最大值，当sum小于0之后，则将重新开始计算新的子串sum。
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
