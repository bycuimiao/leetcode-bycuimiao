package com.bycuimiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/12/19 8:51 下午
 * @Author bycuimiao
 **/
public class A1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
