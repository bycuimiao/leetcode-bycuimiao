package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/12 9:12 下午
 * @Author bycuimiao
 **/
public class A283 {
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 37.7 MB
     * , 在所有 java 提交中击败了
     * 95.42%
     * 的用户
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0 , j = 0; i < nums.length ; i ++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j ++;
            }
        }
        for(int i = 0 ; i < res.length ; i ++){
            nums[i] = res[i];
        }
    }

    /**
     * 一遍循环
     * j指针指向0，i指针指向第一个非0 ，交换即可
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j=0;    //j指针从头遍历，遇到0时停下，至到i指针指向大于0时交换
        for (int i = 1; i < nums.length; i++) {
            if(nums[j]!=0){ //不是0直接++
                j++;
                continue;
            }
            //来到这显然j是等于0，现在只要nums[i]不是0就将值赋予nums[j]，并将nums[i]置0
            if(nums[i]!=0){
                nums[j++]=nums[i]; //值换过后j++;
                nums[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        A283 obj = new A283();
        int[] nums = {1,6,0,0,12,3};
        obj.moveZeroes2(nums);
        for(int i = 0 ; i < nums.length ; i ++){
            System.out.println(nums[i]);
        }
    }
}
