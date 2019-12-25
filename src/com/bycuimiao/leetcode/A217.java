package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/24 11:35 下午
 * @Author bycuimiao
 **/
public class A217 {
    /**
     * 15 ms	42.8 MB
     * 时间复杂度 : O(n)O(n)。
     * search() 和 insert() 各自使用 nn 次，每个操作耗费常数时间。
     *
     * 空间复杂度 : O(n)O(n)。哈希表占用的空间与元素数量是线性关系。
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 5 ms	41.7 MB
     * 时间复杂度 : O(n \log n)O(nlogn)。
     * 排序的复杂度是 O(n \log n)O(nlogn)，扫描的复杂度是 O(n)O(n)。整个算法主要由排序过程决定，因此是 O(n \log n)O(nlogn)。
     *
     * 空间复杂度 : O(1)O(1)。
     * 这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是 O(1)O(1)。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1 ; i ++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
