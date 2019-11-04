package com.bycuimiao.leetcode;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/4 10:26 下午
 * @Author bycuimiao
 **/
public class Q27 {
    /**
     * do myself
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 56.72%
     * 的用户
     * 内存消耗 :
     * 35.2 MB
     * , 在所有 java 提交中击败了
     * 84.87%
     * 的用户
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for(int i = 0 ; i< len ; i ++){
            if(nums[i] == val){
                for(int j = i ; j < nums.length && j+1 < len ; j ++){
                    nums[j] = nums[j+1];
                }
                len --;
                i --;
            }
        }
        return len;
        /**
         * [0,1,2,2,3,0,4,2]
         * 2
         * [3,2,2,3]
         * 3
         * [3,3]
         * 3
         */
    }


    /**
     * 双指针解法
     *
     * 时间复杂度：O(n)，
     * 假设数组总共有 nn 个元素，ii 和 jj 至少遍历 2n2n 步。
     *
     * 空间复杂度：O(1)。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(n)，i 和 n 最多遍历 nn 步。在这个方法中，赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率会更高。
     *
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        //int[] nums = {3,2,2,3};
        //int val = 3;
        //int[] nums = {3,3};
        //int val = 3;
        int len = removeElement(nums,val);
        System.out.println(len);
        for(int i = 0 ; i < len ; i ++){
            System.out.println(nums[i]);
        }
    }

}
