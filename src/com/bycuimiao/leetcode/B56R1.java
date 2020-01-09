package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/1/5 10:22 下午
 * @Author bycuimiao
 **/
public class B56R1 {
    /**
     * 执行用时 :
     * 171 ms
     * , 在所有 Java 提交中击败了
     * 5.04%
     * 的用户
     * 内存消耗 :
     * 57.5 MB
     * , 在所有 Java 提交中击败了
     * 5.04%
     * 的用户
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        sortArrs(intervals);
        List<int[]> ansList = new ArrayList<>();
        int[] target = intervals[0];
        for(int i = 1 ; i < intervals.length ; i ++){
            target = mergeTwo(intervals[i],target,ansList);
        }
        ansList.add(target);
        int[][] ans = new int[ansList.size()][2];
        for(int i = 0 ; i < ansList.size() ; i ++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public int[] mergeTwo(int[] arr ,int[] target , List<int[]> ansList){
        //arr[0] > target[0]
        if( arr[0] > target[1]){
            //两个区间没有交集
            ansList.add(target);
            target = arr;
        }else if(arr[0] < target[1] && arr[1] < target[1]){
            target[0] = target[0];
            target[1] = target[1];
        }else {
            target[0] = target[0];
            target[1] = arr[1];
        }
        return target;
    }

    public void sortArrs(int[][] intervals) {
        for(int i = 0 ; i < intervals.length ; i ++) {
            for(int j = i + 1 ; j < intervals.length ; j ++) {
                if(intervals[i][0] > intervals[j][0]){
                    int t0 = intervals[i][0];
                    int t1 = intervals[i][1];
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = t0;
                    intervals[j][1] = t1;
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{15,18},{1,3},{8,10}};
        int[][] intervals = {{1,4},{2,3}};
        B56R1 obj = new B56R1();
        int[][] ans = obj.merge(intervals);
        System.out.println(ans);
    }

    private static void bubblingSort(int[] arr) {
        int t;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
