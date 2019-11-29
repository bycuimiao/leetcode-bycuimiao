package com.bycuimiao.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @Date 2019/11/28 10:24 下午
 * @Author bycuimiao
 **/
public class B215 {
    /**
     * 讲道理应该创建一个大顶堆来解决这个问题，而不是这样写
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heep = new PriorityQueue();
        for(int num : nums){
            heep.add(num);
            if(heep.size() > k){
                heep.poll();
            }
        }
        return heep.poll();
    }


    public static void main(String[] args) {
        B215 obj = new B215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(obj.findKthLargest(nums,k));
    }
}
