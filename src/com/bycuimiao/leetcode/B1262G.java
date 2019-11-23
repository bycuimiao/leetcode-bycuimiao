package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * LeetCode周赛
 * 这道题太难了！
 * @Date 2019/11/23 9:48 上午
 * @Author bycuimiao
 **/
public class B1262G {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int i = 0 ; i < nums.length ; i ++){
            int mod = nums[i] % 3;
            int a = dp[(3 + 0 - mod) % 3];
            int b = dp[(3 + 1 - mod) % 3];
            int c = dp[(3 + 2 - mod) % 3];
            if (a!=0 || mod == 0) dp[0] = Math.max(dp[0], a + nums[i]);
            if (b!=0 || mod == 1) dp[1] = Math.max(dp[1], b + nums[i]);
            if (c!=0 || mod == 2) dp[2] = Math.max(dp[2], c + nums[i]);
        }
        return dp[0];
    }

    /*public int maxSumDivThree2(int[] nums) {
        int sum = 0;
        List<Integer> dpList1 = new ArrayList<>();
        List<Integer> dpList2 = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            int mod = nums[i] % 3;
            if(mod == 0) sum = sum + nums[i];
            if(mod == 1) dpList1.add(nums[i]);
            if(mod == 2) dpList2.add(nums[i]);;
        }
        dpList1.sort((o1, o2) ->  o2 - o1);
        dpList2.sort((o1, o2) ->  o2 - o1);
        int i = 0;
        int sum1 = 0;
        while (dpList1.size() > i && dpList2.size() > i){
            sum1 = Math.max(sum1 , dpList1.get(i) + dpList2.get(i) + sum1);
            i ++;
        }
        int j = 2;
        while (dpList1.size() > j){
            dpList1.get(j) + dpList1.get(j-1) + dpList1.get(j-2)
        }
        return sum;
    }*/


    /*int maxSumDivThree(vector<int>& nums) {
        int dp[3] = {0, 0, 0};

        for (int i = 0; i < nums.size(); ++i) {
            int mod = nums[i] % 3;

            int a = dp[(3 + 0 - mod) % 3];
            int b = dp[(3 + 1 - mod) % 3];
            int c = dp[(3 + 2 - mod) % 3];

            if (a || mod == 0) dp[0] = std::max(dp[0], a + nums[i]);
            if (b || mod == 1) dp[1] = std::max(dp[1], b + nums[i]);
            if (c || mod == 2) dp[2] = std::max(dp[2], c + nums[i]);
        }
        return dp[0];
    }*/

    public static void main(String[] args) {
        B1262G obj = new B1262G();
        int[] nums = {1,2,3,4,4};
        System.out.println(obj.maxSumDivThree(nums));
    }
}
