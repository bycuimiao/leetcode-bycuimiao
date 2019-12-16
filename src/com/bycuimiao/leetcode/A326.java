package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/16 10:53 下午
 * @Author bycuimiao
 **/
public class A326 {
    /**
     * 15 ms	35.8 MB
     * 时间复杂度 O(logn)
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        while (n % 3 == 0){
            n = n / 3;
        }
        if(n == 1){
            return true;
        }
        return false;
    }

    /**
     * 49 ms	35.5 MB
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        for(int i = 0 ; i < n ; i ++){
            if(n == Math.pow(3,i)){
                return true;
            }else if(n < Math.pow(3,i)){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        A326 obj = new A326();
        System.out.println(obj.isPowerOfThree(1));
        System.out.println(obj.isPowerOfThree(27));
        System.out.println(obj.isPowerOfThree(100));
    }
}
