package com.bycuimiao.leetcode;

/**
 * @Description
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/13 10:38 下午
 * @Author bycuimiao
 **/
public class B6 {
    /**
     * 执行用时 :
     * 91 ms
     * , 在所有 java 提交中击败了
     * 8.12%
     * 的用户
     * 内存消耗 :
     * 51.8 MB
     * , 在所有 java 提交中击败了
     * 35.20%
     * 的用户
     * 写的乱七八糟的
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        //char[] chars = s.toCharArray();
        String[] chars = s.split("");
        int k = 0;//记录字符串数组指针
        //二维数组的长度需要再确切一些，减少内存消耗
        String[][] arr = new String[chars.length][numRows];
        int i = 0 ;//二维数组横向指针
        int j = 0;//二位数组纵向指针
        int type = 0;//移动的方向 0->垂直向下 1->斜向上
        while (k < chars.length){

            if(type == 0){
                if( j < numRows){
                    arr[i][j] = chars[k];
                    k++;
                    j ++;
                    continue;
                }
                i ++;
                j --;
                j --;
            }
            type = 1;

            if(j >0){
                arr[i][j] = chars[k];
                k ++;
                i ++;
                j --;
                continue;
            }
            type = 0;
        }
        String res = "";
        for(int n = 0 ; n < numRows; n ++){
            for(int m = 0 ; m < chars.length ; m ++){
                if(arr[m][n] != null){
                    res = res + arr[m][n];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4 ;
        B6 obj = new B6();
        System.out.println(obj.convert(s,numRows));
    }
}
