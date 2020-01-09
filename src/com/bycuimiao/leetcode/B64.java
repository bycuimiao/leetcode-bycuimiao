package com.bycuimiao.leetcode;

/**
 * @Description TODO
 * @Date 2020/1/6 9:42 下午
 * @Author bycuimiao
 **/
public class B64 {

    /**
     * 动态规划
     * 二维数组
     * 执行用时 :
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 8.40%
     * 的用户
     * 内存消耗 :
     * 40.6 MB
     * , 在所有 Java 提交中击败了
     * 77.21%
     * 的用户
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        //dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        for(int i = grid.length - 1 ; i >=0 ; i --){
            for (int j = grid[0].length - 1 ; j >= 0 ; j --){
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if(i + 1 < grid.length){
                    a = dp[i+1][j];
                }
                if(j + 1 < grid[0].length){
                    b = dp[i][j+1];
                }
                if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE){
                    a = 0;
                    b = 0;
                }
                dp[i][j] = grid[i][j] +  Math.min(a,b) ;
            }
        }
        return dp[0][0];
    }


    /**
     * 递归法
     * 邹觉定是你啦
     * 超时
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        return recursion1(grid,0,0);
    }

    public int recursion1(int[][] grid , int i , int j){
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        //return grid[i][j] + Math.min(recursion(grid,i+1,j),recursion(grid,i,j+1));
        return grid[i][j] + Math.min(recursion1(grid, i + 1, j), recursion1(grid, i, j + 1));
    }

    public int calculate01(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate01(grid, i + 1, j), calculate01(grid, i, j + 1));
    }
    public int minPathSum01(int[][] grid) {
        return calculate01(grid, 0, 0);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        B64 obj = new B64();
        System.out.println(obj.minPathSum1(grid));
        System.out.println(obj.minPathSum01(grid));
        System.out.println(obj.minPathSum(grid));
    }


}
