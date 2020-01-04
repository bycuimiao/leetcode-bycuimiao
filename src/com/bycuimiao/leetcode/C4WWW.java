package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/1/4 12:30 下午
 * @Author bycuimiao
 **/
public class C4WWW {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        for(int i = 0 , j = 0; ;){
            int num;
            if(len % 2 == 1){
                if(i + j == len / 2 + 1){
                    return Math.max(nums1[i], nums2[j]);
                }
            }else {
                if(i + j == len / 2){
                    int a ;
                    if(i - 1 >= 0 && j - 1 >= 0){
                        a = Math.max(nums1[i-1], nums2[j-1]);
                    }else if(i - 1 < 0){
                        a = nums2[j-1];
                    }else {
                        a = nums1[i-1];
                    }
                    return ((double) (Math.min(nums1[i],nums2[j]) + a))/2;
                }
            }
            if(j >= nums2.length){
                num = nums1[i];
                i ++;
            }else if(i >= nums1.length){
                num = nums2[j];
                j ++;
            }else if(nums1[i] > nums2[j]){
                num = nums2[j];
                j ++;
            }else {
                num = nums1[i];
                i ++;
            }
        }
    }




    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            //处理特例
            return handleSpecial(nums2);
        }
        if(nums2.length == 0){
            //处理特例
            return handleSpecial(nums1);
        }

        int len = nums1.length + nums2.length;
        int i = 0 , j = 0;
        int num = Math.min(nums1[i] , nums2[j]);
        int before = -1;
        while (true){
            if(i + j == len / 2){
                if(len % 2 == 1){
                    return num;
                }else {
                    return ((double)(before+num))/2;
                }
            }
            if(i > nums1.length - 1){
                before = num;
                num = nums2[j];
                j ++;
                continue;
            }else if(j > nums2.length - 1){
                before = num;
                num = nums1[i];
                i ++;
                continue;
            }

            if(num == nums1[i]){
                i ++;
                if(i >= nums1.length - 1){
                    before = num;
                    num = nums2[j];
                    j ++;
                    continue;
                }
                if(nums1[i] > nums2[j]){
                    before = num;
                    num = nums1[i];
                    i ++;
                    continue;
                }else {
                    before = num;
                    num = nums2[j];
                    j ++;
                    continue;
                }
            }else {
                j ++;
                if(nums2[j] > nums1[i]){
                    before = num;
                    num = nums2[j];
                    j ++;
                    continue;
                }else {
                    before = num;
                    num = nums1[i];
                    i ++;
                    continue;
                }
            }
        }
        /*if(len % 2 == 1){

        }else {
            return -1;
        }*/
    }

    public double handleSpecial(int[] nums){
        if(nums.length % 2 == 1){
            return nums[nums.length / 2];
        }else {
            return ((double) (nums[nums.length / 2 - 1] + nums[nums.length/2])) / 2;
        }
    }

    public static void main(String[] args) {
        C4WWW obj = new C4WWW();
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        System.out.println(obj.findMedianSortedArrays(nums1,nums2));
    }
}
