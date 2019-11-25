package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description: TODO
 * @date 2019-11-25 17:35
 */
public class A1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int min = 0;
        for(int i = 1 ; i < points.length ; i ++){
            min = min + Math.max(Math.abs(points[i][0] - points[i-1][0]),Math.abs(points[i][1] - points[i-1][1]));
        }
        return min;
    }

    public static void main(String[] args) {
        A1266 obj = new A1266();
        //[1,1],[3,4],[-1,0]
        int[][] points = {{1,1},{3,4},{-1,0}};
        int min = obj.minTimeToVisitAllPoints(points);
        System.out.println(min);

    }
}
