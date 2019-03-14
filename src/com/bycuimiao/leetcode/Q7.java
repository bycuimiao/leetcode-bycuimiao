package com.bycuimiao.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。.
 *
 * @author cuimiao
 * @since 14 March 2019
 */
public class Q7 {
	public static void main(String[] args) {
		System.out.println(reverse(9646324351L));
	}

	public static int reverse(long x) {
		try {
			char[] arr;
			boolean flag = false;
			if(x < 0){
				x = -x;
				flag = true;
			}
			if(x >= 0){
				arr = String.valueOf(x).toCharArray();
				String str = "";
				for(int i = arr.length-1 ; i >= 0 ; i --){
					str += arr[i];
				}
				if (flag){
					return -Integer.valueOf(str);
				}
				return Integer.valueOf(str);
			}
			return (int)x;
		}catch (Exception e){
			return 0;
		}
	}

	/**
	 * java.lang.NumberFormatException: For input string: "9646324351"
	 *   at line 65, java.lang.NumberFormatException.forInputString
	 *   at line 583, java.lang.Integer.parseInt
	 *   at line 766, java.lang.Integer.valueOf
	 *   at line 18, Solution.reverse
	 *   at line 54, __DriverSolution__.__helper__
	 *   at line 98, __Driver__.main
	 */
}
