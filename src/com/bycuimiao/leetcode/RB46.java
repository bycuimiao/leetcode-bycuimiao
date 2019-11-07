package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/7 9:13 下午
 * @Author bycuimiao
 **/
public class RB46 {
    /**
     * 回溯算法
     * 可以通过这个例子理解“回溯”算法的“状态重置”的操作，“回溯搜索” = “深度优先遍历 + 状态重置 + 剪枝”。（“剪枝”可以通过第 47 题来理解。）
     *
     * 1、“深度优先遍历” 就是“不撞南墙不回头”；
     *
     * 2、回头的时候要“状态重置”，即回到上一次来到的那个地方，“状态”要和上一次来的时候一样。
     *
     * 3、在代码上，往往是在执行下一层递归的前后，代码的形式是“对称的”。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param nums
     * @param output
     * @param first
     */
   /* public static void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists);
    }*/



    // curSize 表示当前的路径 path 里面有多少个元素

    private static void generatePermution(int[] nums,
                                          boolean[] visited,
                                          int curSize,
                                          int len,
                                          Stack<Integer> path,
                                          List<List<Integer>> res) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> permute = permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
