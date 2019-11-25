package com.bycuimiao.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/22 9:14 下午
 * @Author bycuimiao
 **/
public class C128 {
    /**
     * 这种方法的时间复杂度是O(nlogn)
     * 3 ms	37.8 MB 击败了99.70%的用户
     *
     *
     * ps:这道题的难点应该是O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int tmp = 1;
        for(int i = 1 ; i < nums.length ; i ++){
            if(nums[i-1] == nums[i]){
                continue;
            }
            if(nums[i-1] + 1 == nums[i]){
                tmp = tmp + 1;
            }else {
                tmp = 1;
            }
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }

    /**
     * 这个才是时间复杂度O(n)的答案
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    public static void main(String[] args) {
        int[] nums = {100,4,200,-1,0,1,1,3,2};
        C128 obj = new C128();
        int max = obj.longestConsecutive(nums);
        System.out.println(max);
    }
}
