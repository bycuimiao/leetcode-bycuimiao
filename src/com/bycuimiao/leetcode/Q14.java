package com.bycuimiao.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * @author cuimiao
 * @since 16 March 2019
 */
public class Q14 {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		//String[] strs = {"ab","aa"};
		//String[] strs = {"ca","a"};
		System.out.println(longestCommonPrefix(strs));
	}

	/**
	 * 执行用时 : 8 ms, 在Longest Common Prefix的Java提交中击败了82.43% 的用户
	 * 内存消耗 : 38 MB, 在Longest Common Prefix的Java提交中击败了1.72% 的用户
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		String prefix = strs[0];
		for(int i = 1 ;i < strs.length ; i ++){
			if(prefix.length() > strs[i].length()){
				prefix = strs[i];
			}
		}
		while (prefix.length() > 0){
			boolean flag = true;
			for(int i = 0 ;i < strs.length ; i ++){
				if(!strs[i].startsWith(prefix)){
					flag = false;
					break;
				}
			}
			if(flag){
				return prefix;
			}
			if(prefix.length() == 1){
				prefix = "";
			}else {
				prefix = prefix.substring(0,prefix.length()-1);
			}
		}

		return prefix;
	}
}
