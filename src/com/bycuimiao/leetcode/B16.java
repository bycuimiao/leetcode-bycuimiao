package com.bycuimiao.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/20 11:02 下午
 * @Author bycuimiao
 **/
public class B16 {
    /**
     * 总时间复杂度：O(nlogn) + O(n^2) = O(n^2)O(nlogn)+O(n
     * 2
     *  )=O(n
     * 2
     *  )
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i ++){
            int left = i + 1;
            int right = nums.length - 1;
            // 感觉left >= right并不是最好的终止条件
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    right --;
                }else if(sum < target){
                    left ++;
                }else {
                    // 相等则直接返回结果，无需继续比较
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        B16 obj = new B16();
        int[] nums = {-1,2,1,4};
        int target = 1;
        System.out.println(obj.threeSumClosest(nums,target));
    }
}
