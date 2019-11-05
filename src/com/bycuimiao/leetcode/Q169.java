package com.bycuimiao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/5 10:23 下午
 * @Author bycuimiao
 **/
public class Q169 {
    /**
     * 执行用时 :
     * 21 ms
     * , 在所有 java 提交中击败了
     * 31.12%
     * 的用户
     * 内存消耗 :
     * 39.3 MB
     * , 在所有 java 提交中击败了
     * 94.71%
     * 的用户
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int target = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else {
                int n = map.get(nums[i])+1;
                if(n > target){
                    return nums[i];
                }
                map.put(nums[i],n);
            }
        }
        return -1;
    }


    /**
     * 时间复杂度：O(nlgn)O(nlgn)
     *
     * 用 Python 和 Java 将数组排序开销都为 O(nlgn)O(nlgn) ，它占据了运行的主要时间。
     *
     * 空间复杂度：O(1)O(1) 或者 O(n)O(n)
     *
     * 我们将 nums 就地排序，如果不能就低排序，我们必须使用线性空间将 nums 数组拷贝，然后再排序
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,1,1,1,1,1};
        int n = majorityElement(nums);
        System.out.println(n);
    }
}
