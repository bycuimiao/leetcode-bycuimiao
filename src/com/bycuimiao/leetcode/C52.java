package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/11/26 10:26 下午
 * @Author bycuimiao
 **/
public class C52 {
    /**
     * 马丹，n=9的时候超时了
     * 26104ms
     * 20823
     * 13806
     * 71
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        //List<List<String>> resList = new ArrayList<>();
        int[] sum = {0};
        backtrace(n,0,new String[n][n],sum);
        return sum[0];
    }

    public void backtrace(int n , int m, String[][] res, int[] sum ){
        if(m == n){
            //TODO 将res适配后 add 进 resList
            //resList.add(adapt(res));
            sum[0]++;
            return;
        }
        if(m > n){
            //剪枝
            return;
        }
        int i = m;
        for (int j = 0 ; j < n ; j ++){
            if(res[i][j] == null){
                List<List<Integer>> lists = new ArrayList<>();
                setQ(res,i,j,lists);
                backtrace(n,m+1,res,sum);
                popQ(res,i,j,lists);
            }
        }
    }

    public void setQ(String[][] res , int i , int j , List<List<Integer>> lists){
        res[i][j] = "Q";
        for(int q = 0 ; q < res.length ; q ++){
            for(int p = 0 ; p < res[q].length ; p ++){
                if(q == i && res[q][p] == null){
                    res[q][p] = ".";
                    List<Integer> list = new ArrayList<>();
                    list.add(q);
                    list.add(p);
                    lists.add(list);
                }
                if(p == j && res[q][p] == null){
                    res[q][p] = ".";
                    List<Integer> list = new ArrayList<>();
                    list.add(q);
                    list.add(p);
                    lists.add(list);
                }
                if(Math.abs(i-q) == Math.abs(j-p) && res[q][p] == null){
                    res[q][p] = ".";
                    List<Integer> list = new ArrayList<>();
                    list.add(q);
                    list.add(p);
                    lists.add(list);
                }
            }
        }
    }
    public void popQ(String[][] res , int i , int j , List<List<Integer>> lists){
        res[i][j] = null;

        for(int q = 0 ; q < lists.size() ; q ++ ){
            res[lists.get(q).get(0)][lists.get(q).get(1)] = null;
        }
    }

    /*public List<String> adapt(String[][] res){
        List<String> strList = new ArrayList<>();
        for(int i = 0 ; i < res.length ; i ++){
            String str = "";
            for (int j = 0 ; j < res[i].length ; j ++){
                str = str + res[i][j];
            }
            strList.add(str);
        }
        return strList;
    }*/

    public static void main(String[] args) {
        C52 obj = new C52();
        int n = 9;
        long start = System.currentTimeMillis();
        int sum = obj.totalNQueens(n);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(sum);
    }
}
