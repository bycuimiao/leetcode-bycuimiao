package com.bycuimiao.leetcode;

/**
 * @author miao.cui
 * @description:
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 * @date 2019-04-25 10:20
 */
public class Q58 {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String [] arr = s.split(" ");
        if(arr.length == 0){
            return 0;
        }
        return arr[arr.length-1].length();
    }
}
