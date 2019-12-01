package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/29 10:32 下午
 * @Author bycuimiao
 **/
public class B300WWWW {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        /*for(int i = 0 ; i < dp.length ; i ++){
            dp[i] = 1;
        }*/
        for(int i = 0 ; i < nums.length - 1 ; i ++){
            int t = nums[i];
            for(int j = i + 1 ; j < nums.length ; j ++){
                if(t < nums[j]){
                    dp[i] ++;
                    t = nums[j];
                }
            }
        }
        int max = 0;
        for(int num : dp){
            if(num > max){
                max = num;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        B300WWWW obj = new B300WWWW();
        //[4,10,4,3,8,9]
        //[10,9,2,5,3,4]
        int[] nums = {10,9,2,5,3,4};
        System.out.println(obj.lengthOfLIS(nums));
    }
}
