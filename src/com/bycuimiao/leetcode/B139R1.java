package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author miao.cui
 * @description: TODO
 * @date 2019-11-28 19:36
 */
public class B139R1 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        B139R1 obj = new B139R1();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("abc");
        wordDict.add("ab");
        wordDict.add("cd");
        wordDict.add("ef");
        System.out.println(obj.wordBreak("abcdef",wordDict));
    }
}
