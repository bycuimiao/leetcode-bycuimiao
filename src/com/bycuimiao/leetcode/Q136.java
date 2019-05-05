package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @date 2019-05-05 09:45
 */
public class Q136 {

    public static void main(String[] args) {
        int[] nums = {9,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数于0异或为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     * 异或：相同为0，不同为1. 异或同一个数两次，原数不变。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            res = res ^ nums[i];
        }
        return res;
    }
}
