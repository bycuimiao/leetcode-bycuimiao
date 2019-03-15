package com.bycuimiao.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author cuimiao
 * @since 15 March 2019
 */
public class Q9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(343));
		System.out.println(isPalindrome(-20));
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(2332));
		System.out.println(isPalindrome(22322));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0){
			return false;
		}
		if(x < 10){
			return true;
		}
		char[] c = String.valueOf(x).toCharArray();
		for(int i = 0 ; i < c.length / 2 ; i ++){
			if(c[i] == c[c.length - 1 - i]){
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
}
