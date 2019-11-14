package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/11/14 10:11 下午
 * @Author bycuimiao
 **/
public class A784R2 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        // 特判
        int len = S.length();
        if (len == 0) {
            return res;
        }
        char[] chars = S.toCharArray();
        dfs(0, len, chars, res);
        return res;
    }

    private void dfs(int index, int len, char[] chars, List<String> res) {
        if (index == len) {
            res.add(new String(chars));
            return;
        }
        dfs(index + 1, len, chars, res);
        if (Character.isLetter(chars[index])) {
            chars[index] ^= (1 << 5);
            dfs(index + 1, len, chars, res);
        }
    }

    public static void main(String[] args) {
        A784R2 solution = new A784R2();
        String S = "a1b2";
        List<String> letterCasePermutation = solution.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }

}
