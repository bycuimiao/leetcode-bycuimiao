package com.bycuimiao.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/5 9:42 下午
 * @Author bycuimiao
 **/
public class Q88 {
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.1 MB
     * , 在所有 java 提交中击败了
     * 84.74%
     * 的用户
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0 , k = 0;
        while (i < m + n){
            if(j < m && k < n && nums1[j] > nums2[k]){
                nums[i] = nums2[k];
                i ++;
                k ++;
            }else if(j < m && k < n && nums1[j] <= nums2[k]){
                nums[i] = nums1[j];
                i ++;
                j ++;
            }else if(j == m && k != n){
                nums[i] = nums2[k];
                i ++;
                k ++;
            }else {
                nums[i] = nums1[j];
                i ++;
                j ++;
            }
        }
        for(int q = 0 ; q < nums.length ; q ++ ){
            nums1[q] = nums[q];
        }
    }

    /**
     * 时间复杂度 : O((n+m)log(n+m))
     * 空间复杂度 : O(1)。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;
        merge(num1,m,num2,n);
        for(int i = 0; i < num1.length ; i ++){
            System.out.println(num1[i]);
        }
    }
}
