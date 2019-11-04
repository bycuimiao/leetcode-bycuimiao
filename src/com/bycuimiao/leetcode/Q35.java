package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/4 11:17 下午
 * @Author bycuimiao
 **/
public class Q35 {

    /**
     * myself
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39 MB
     * , 在所有 java 提交中击败了
     * 54.84%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        //[1,3,5,6], 2
        //[1,3,5,6], 7
        //int[] nums = {1,3,5,6};
        //int target = 5;
        int[] nums = {1,3,5,6};
        int target = 0;
        int index = searchInsert(nums,target);
        System.out.println(index);
        /*for(int i = 0 ; i < nums.length ; i ++ ){
            System.out.println(nums[i]);
        }*/
    }

}
