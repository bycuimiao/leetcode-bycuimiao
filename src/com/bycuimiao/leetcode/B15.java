package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/19 9:16 下午
 * @Author bycuimiao
 **/
public class B15 {
    /**
     * 时间复杂度O(n3)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = i + 1 ; j < nums.length ; j ++){
                for(int k = j + 1 ; k < nums.length ; k ++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //TODO 去重
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 找到分界处
        for(int i = 0 ; i < nums.length ; i ++){
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int num = nums[i] + nums[left] + nums[right];
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right -- ;
                    while (right >=0 && nums[right] == nums[right+1]) right--;
                    left ++ ;
                    while (left < nums.length-1 && nums[left] == nums[left-1]) left++;
                }else if(num > 0){
                    right -- ;
                    while (right >=0 && nums[right] == nums[right+1]) right--;
                }else {
                    left ++ ;
                    while (left < nums.length-1 && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        B15 obj = new B15();
        //[-2,0,0,2,2]
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = obj.threeSum(nums);
        lists.forEach(list -> {list.forEach(System.out::println); System.out.println();});
    }
}
