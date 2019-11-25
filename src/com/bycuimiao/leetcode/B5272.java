package com.bycuimiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Date 2019/11/24 10:37 上午
 * @Author bycuimiao
 **/
public class B5272 {
    public int countServers(int[][] grid) {
        Set<String> haveNums = new HashSet<>();
        for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[i].length ; j ++){
                if(grid[i][j] == 1){
                    haveServer(grid,i,j,haveNums);
                }
            }
        }
        return haveNums.size();
    }

    public void haveServer(int[][] grid , int i , int j , Set<String> haveNums){
        if(haveNums.contains(String.valueOf(i)+","+j)){
            return ;
        }
        for(int m = 0 ; m < grid.length ; m ++){
            if(m == i){
                continue;
            }
            if(grid[m][j] == 1){
                haveNums.add(String.valueOf(m)+","+String.valueOf(j));
                haveNums.add(String.valueOf(i)+","+String.valueOf(j));
            }
        }
        for(int n = 0 ; n < grid[i].length ; n ++){
            if(n == j){
                continue;
            }
            if(grid[i][n] == 1){
                haveNums.add(String.valueOf(i)+","+String.valueOf(n));
                haveNums.add(String.valueOf(i)+","+String.valueOf(j));
            }
        }
        return ;
    }


    public static void main(String[] args) {
        B5272 obj = new B5272();
        //[[1,0,0,1,0],[0,0,0,0,0],[0,0,0,1,0]]
        int[][] grid = {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        int count = obj.countServers(grid);
        System.out.println(count);
    }
}
