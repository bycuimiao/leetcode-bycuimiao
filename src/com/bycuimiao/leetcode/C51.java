package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 回溯算法经典N皇后问题
 * 就决定是你啦！皮卡丘！
 * @Date 2019/11/25 9:46 下午
 * @Author bycuimiao
 **/
public class C51 {
    int sum = 0;
    /**
     * 马丹，n=9的时候超时了
     * 26104ms
     * 20823
     * 13806
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        backtrace(n,0,new String[n][n],resList);
        return resList;
    }

    public void backtrace(int n , int m, String[][] res, List<List<String>> resList ){
        if(m == n){
            //TODO 将res适配后 add 进 resList
            resList.add(adapt(res));
            return;
        }
        if(m > n){
            //剪枝
            return;
        }
        if(n*n - sum < n-m){
            //剪枝
            return;
        }
        /*if(!canContinue(res,n,m)){
            //剪枝
            return;
        }*/
        for(int i = m ; i < n ; i ++){
            for (int j = 0 ; j < n ; j ++){
                if(res[i][j] == null){
                    /*if(!canSetQ(res,i,j)){
                        continue;
                    }*/
                    List<List<Integer>> lists = new ArrayList<>();
                    setQ(res,i,j,lists);
                    backtrace(n,m+1,res,resList);
                    popQ(res,i,j,lists);
                }
            }
        }
    }

    public boolean canContinue(String[][] res , int n , int m){
        int count = 0;
        for(int i = 0 ; i < res.length ; i ++){
            for(int j = 0 ; j < res[i].length ; j ++){
                if(res[i][j] == null){
                    count ++;
                    if(count >= (n-m)){
                        return true;
                    }
                }
            }
        }
        if(count >= (n-m)){
            return true;
        }
        return false;
    }

    public boolean canSetQ(String[][] res , int i , int j){
        for(int q = 0 ; q < res.length ; q ++){
            for(int p = 0 ; p < res[q].length ; p ++){
                if(q == i ){
                    if("Q".equals(res[q][p])){
                        return false;
                    }
                }
                if(p == j){
                    if("Q".equals(res[q][p])){
                        return false;
                    }
                }
                if(Math.abs(i-q) == Math.abs(j-p)){
                    if("Q".equals(res[q][p])){
                        return false;
                    }
                }
            }
        }
        return true;
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
                    sum ++;
                }
                if(p == j && res[q][p] == null){
                    res[q][p] = ".";
                    List<Integer> list = new ArrayList<>();
                    list.add(q);
                    list.add(p);
                    lists.add(list);
                    sum ++;
                }
                if(Math.abs(i-q) == Math.abs(j-p) && res[q][p] == null){
                    res[q][p] = ".";
                    List<Integer> list = new ArrayList<>();
                    list.add(q);
                    list.add(p);
                    lists.add(list);
                    sum ++;
                }
            }
        }
    }
    public void popQ(String[][] res , int i , int j , List<List<Integer>> lists){
        res[i][j] = null;

        for(int q = 0 ; q < lists.size() ; q ++ ){
            res[lists.get(q).get(0)][lists.get(q).get(1)] = null;
            sum --;
        }

        /*for(int q = 0 ; q < res.length ; q ++){
            for(int p = 0 ; p < res[q].length ; p ++){
                if(q == i){
                    res[q][p] = null;
                }
                if(p == j){
                    res[q][p] = null;
                }
                if(Math.abs(i-q) == Math.abs(j-p) && res[q][p] == null){
                    res[q][p] = ".";
                }
            }
        }*/
    }

    public List<String> adapt(String[][] res){
        List<String> strList = new ArrayList<>();
        for(int i = 0 ; i < res.length ; i ++){
            String str = "";
            for (int j = 0 ; j < res[i].length ; j ++){
                str = str + res[i][j];
            }
            strList.add(str);
        }
        return strList;
    }

    public static void main(String[] args) {
        C51 obj = new C51();
        int n = 9;
        long start = System.currentTimeMillis();
        List<List<String>> lists = obj.solveNQueens(n);
        System.out.println(System.currentTimeMillis() - start);
        lists.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println("------------");
        });
    }
}
