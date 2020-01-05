package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/21 9:22 下午
 * @Author bycuimiao
 **/
public class B56WWW {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1){
            return intervals;
        }
        //Arrays.sort(intervals);
        //List<Map<Integer,Integer>> list = new ArrayList<>();
        Map map = new HashMap();
        for(int i = 0 ; i < intervals.length ; i ++){
            for (int j = 0 ; j < intervals[i].length ; j ++){
                //Map map = new HashMap();
                if(j == 0){
                    if(map.get(intervals[i][j]) != null){
                        map.put(intervals[i][j],2);
                    }else {
                        map.put(intervals[i][j],0);
                    }
                }else {
                    if(map.get(intervals[i][j]) != null){
                        map.put(intervals[i][j],2);
                    }else {
                        map.put(intervals[i][j],1);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.comparingInt(o -> o));
        Stack<Integer> resStack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        int flag = 0;
        for(int i = 0 ; i < list.size(); i ++){
            int tmp = 0;
            if(map.get(list.get(i)).equals(0)){
                //flag ++;
                resStack.push(list.get(i));
            }else if(map.get(list.get(i)).equals(1)){
                //flag --;
                tmp = resStack.pop();
            }else {

            }
            if(resStack.size() == 0){
                resList.add(tmp);
                resList.add(list.get(i));
            }
        }
        int[][] res = new int[resList.size()/2][2];
        for(int j = 0 ; j < resList.size()/2 ; j ++){
            for(int i = j * 2,k = 0 ; k < 2 ; k ++,i++){
                res[j][k] = resList.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{1,3},{8,10},{15,18}};
        B56WWW obj = new B56WWW();
        int[][] mergeArr = obj.merge(intervals);
        for(int i = 0 ; i < mergeArr.length ; i ++){
            for (int j = 0 ; j < mergeArr[i].length ; j ++){
                System.out.println(mergeArr[i][j]);
            }
        }
    }
}
