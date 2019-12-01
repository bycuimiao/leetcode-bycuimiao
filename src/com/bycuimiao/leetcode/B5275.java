package com.bycuimiao.leetcode;

/**
 * @Description TODO
 * @Date 2019/12/1 10:32 上午
 * @Author bycuimiao
 **/
public class B5275 {
    public String tictactoe(int[][] moves) {
        if(moves.length < 3){
            return "Pending";
        }
        int[][] chessboard = new int[3][3];
        for(int i = 0 ; i < moves.length ; i ++){
            if(i % 2 == 0){
                chessboard[moves[i][0]][moves[i][1]] = 1;
            }else {
                chessboard[moves[i][0]][moves[i][1]] = 2;
            }
            if(i >= 2){
                //校验是否有人胜利
                if(win(chessboard,moves[i][0],moves[i][1])){
                    if(chessboard[moves[i][0]][moves[i][1]] == 1){
                        return "A";
                    }else {
                        return "B";
                    }
                }
            }
        }
        if(moves.length != 9){
            return "Pending";
        }else {
            return "Draw";
        }
    }

    public boolean win(int[][] chessboard , int m , int n){
        int count = 0;

        // 斜线1
        int mt = m;
        int nt = n;
        mt = mt - 1;
        nt = nt - 1;
        while (mt >=0 && mt < 3 && nt >=0 && nt<3){
            //
            if(chessboard[mt][nt] == chessboard[m][n]){
                count ++;
                mt = mt - 1;
                nt = nt - 1;
            }else {
                break;
            }
        }
        int ma = m + 1;
        int na = n + 1;
        while (ma >=0 && ma < 3 && na >=0 && na<3){
            //
            if(chessboard[ma][na] == chessboard[m][n]){
                count ++;
                ma = ma + 1;
                na = na + 1;
            }else {
                count = 0;
                break;
            }
        }
        if(count == 2){
            return true;
        }else {
            count = 0;
        }

        // 斜线2
        int mb = m -1;
        int nb = n + 1;
        while (mb >=0 && mb < 3 && nb >=0 && nb<3){
            //
            if(chessboard[mb][nb] == chessboard[m][n]){
                count ++;
                mb = mb - 1;
                nb = nb + 1;
            }else {
                break;
            }
        }
        int mc = m + 1;
        int nc = n - 1;
        while (mc >=0 && mc < 3 && nc >=0 && nc<3){
            //
            if(chessboard[mc][nc] == chessboard[m][n]){
                count ++;
                mc = mc + 1;
                nc = nc - 1;
            }else {
                count = 0;
                break;
            }
        }
        if(count == 2){
            return true;
        }else {
            count = 0;
        }

        //横线
        int md = m;
        int nd = n - 1;
        while (md >=0 && md < 3 && nd >=0 && nd<3){
            //
            if(chessboard[md][nd] == chessboard[m][n]){
                count ++;
                //md = md;
                nd = nd - 1;
            }else {
                break;
            }
        }
        int me = m ;
        int ne = n + 1;
        while (me >=0 && me < 3 && ne >=0 && ne<3){
            //
            if(chessboard[me][ne] == chessboard[m][n]){
                count ++;
                //me = me;
                ne = ne + 1;
            }else {
                count = 0;
                break;
            }
        }
        if(count == 2){
            return true;
        }else {
            count = 0;
        }
        //竖线
        int mf = m - 1;
        int nf = n;
        while (mf >=0 && mf < 3 && nf >=0 && nf<3){
            //
            if(chessboard[mf][nf] == chessboard[m][n]){
                count ++;
                mf = mf - 1;
                //nf = nf;
            }else {
                break;
            }
        }
        int mg = m + 1;
        int ng = n ;
        while (mg >=0 && mg < 3 && ng >=0 && ng<3){
            //
            if(chessboard[mg][ng] == chessboard[m][n]){
                count ++;
                mg = mg + 1;
                ng = ng;
            }else {
                count = 0;
                break;
            }
        }

        if(count == 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        B5275 obj = new B5275();
        //[0,0],[2,0],[1,1],[2,1],[2,2]
        //[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]
        //[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
        //[[0,0],[1,1]]
        //[[2,2],[2,0],[1,1],[0,2],[2,1],[1,2]]
        //[[2,1],[1,2],[1,0],[1,1],[0,2],[2,0],[0,1],[0,0]]
        int[][] moves = {{2,1},{1,2},{1,0},{1,1},{0,2},{2,0},{0,1},{0,0}};
        System.out.println(obj.tictactoe(moves));
    }
}
