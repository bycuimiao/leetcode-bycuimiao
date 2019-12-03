package com.bycuimiao.game;

import java.util.List;

/**
 * @Description
 * 卢比克斯管道
 * 稍微有点难啊，智商堪忧
 * @Date 2019/12/3 8:49 下午
 * @Author bycuimiao
 **/
public class RubixPipeline {

    public char[][] pipeline(char[][] chessboard){
        //检索管道开始位置
        int[] index = indexPipeStart(chessboard);
        //如果没有可以开始的管道节点，则结束搜索
        if(index[0] == -1 || index[1] == -1){
            return chessboard;
        }
        //拿到开始节点，开启搜索对应的节点，回溯剪枝
        int m = index[0];
        int n = index[1];
        char target = chessboard[m][n];
        int result = 0;
        while (result != -1){
            result = move(chessboard,m,n,target);
            if(result == 1){
                m--;
            }else if(result ==2){
                m++;
            }else if(result == 3){
                n--;
            }else if(result == 4){
                n++;
            }
        }
        return chessboard;
    }

    public int move(char[][] chessboard , int m , int n , char target){
        //向下
        if (m - 1 >= 0 && chessboard[m-1][n] == '0'){
            chessboard[m-1][n] = (char)(target + 32);
            //m--;
            return 1;
        }
        //向上
        if (m + 1 < chessboard.length && chessboard[m+1][n] == '0'){
            chessboard[m+1][n] = (char)(target + 32);
            //m++;
            return 2;
        }
        //向左
        if (n - 1 >= 0 && chessboard[m][n-1] == '0'){
            chessboard[m][n-1] = (char)(target + 32);
            //n--;
            return 3;
        }
        //向右
        if (n + 1 < chessboard[m].length && chessboard[m][n+1] == '0'){
            chessboard[m][n+1] = (char)(target + 32);
            //n++;
            return 4;
        }
        //无法移动
        return -1;
    }

    public int[] indexPipeStart(char[][] chessboard){
        int[] index = {-1,-1};
        for(int i = 0 ; i < chessboard.length ; i ++){
            for(int j = 0 ; j < chessboard[i].length ; j ++){
                if(isPipeStart(chessboard,i,j)){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

    public boolean isPipeStart(char[][] chessboard , int i , int j){
        //判断是否为管道节点
        if(chessboard[i][j] >= 'A' && chessboard[i][j] <= 'Z'){
            //判断是否为开始节点
            if(i-1 >=0 && (chessboard[i-1][j]-chessboard[i][j] == 32 || chessboard[i-1][j]-chessboard[i][j] == 0)){
                return false;
            }else if(i+1 < chessboard.length && (chessboard[i+1][j]-chessboard[i][j] == 32 || chessboard[i+1][j]-chessboard[i][j] == 0)){
                return false;
            }else if(j-1 >= 0 && (chessboard[i][j-1] - chessboard[i][j] == 32 || chessboard[i][j-1] - chessboard[i][j] == 0)){
                return false;
            }else if(j+1 < chessboard[i].length && (chessboard[i][j+1] - chessboard[i][j] == 32 || chessboard[i][j+1] - chessboard[i][j] == 0)){
                return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RubixPipeline obj = new RubixPipeline();
        //System.out.println('a'-'A');
        char[][] chessboard = {{'0','A','0'},{'0','0','A'},{'0','0','0'}};
        char[][] pipe = obj.pipeline(chessboard);
        for (char[] cs : pipe){
            for(char c : cs){
                System.out.print(String.valueOf(c) + " ");
            }
            System.out.println();
        }
    }
}
