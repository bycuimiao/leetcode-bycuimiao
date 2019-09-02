package com.bycuimiao.leetcode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author miao.cui
 * @description: 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @date 2019-04-29 14:33
 */
public class Q204 {
    public static void main(String[] args) {
        System.out.println(countPrimes3(13));
    }

    /**
     * 超时
     * 输入：499979
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (i == 2) {
                num++;
            }
            for (int j = 2; j < i; j++) {
                if (j == i - 1) {
                    num++;
                    break;
                }
                if (i % j == 0) {
                    break;
                }
            }
        }
        return num;
    }

    /**
     * 超时
     * 输入：1500000
     *
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (j != 1 && i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    /**
     * 厄拉多塞筛法
     * 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.2后面紧跟的数即为下一个质数3,
     * 然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
     * 执行用时 : 31 ms, 在Count Primes的Java提交中击败了61.49% 的用户
     * 内存消耗 : 39.9 MB, 在Count Primes的Java提交中击败了7.60% 的用户
     * @param n
     * @return
     */
    public static int countPrimes3(int n) {
        if (n < 3) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        int sum = n - 2;
        for (int i = 2; i < Math.sqrt(n); i++) {
            //这个就好了
            if (arr[i] == 0) {
                for (int j = i * i; j < n; j = j + i){
                    arr[j] = arr[j] + 1;
                    if(arr[j] == 1){
                        sum --;
                    }
                }
            }
        }
        return sum;
    }

    private static int countPrimes33(int n){
        //long time = System.currentTimeMillis();
        if(n < 3){
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i < Math.sqrt(n) ; i ++){
            //超时1500000  用时1196毫秒，胃疼。。。
            /*while (arr[i] != 0){
                i++;
            }
            for(int j = i + 1 ; j < n ; j ++){
                if(arr[j] == 0){
                    if(j % i == 0){
                        arr[j] = 1;
                    }
                }
            }*/
            //这个就好了
            if(arr[i]==0){
                for(int j=i*i;j<n;j=j+i)
                    arr[j]=1;
            }
        }
        int num = 0;
        for(int i = 0 ;i < n ; i ++){
            if(arr[i] == 0){
                num++;
            }
        }
        //System.out.println(System.currentTimeMillis() - time );
        return num;
    }

    /**
     * 执行用时 : 40 ms, 在Count Primes的Java提交中击败了40.00% 的用户
     * 内存消耗 : 44.7 MB, 在Count Primes的Java提交中击败了5.03% 的用户
     * 浩哥解法
     * @param n
     * @return
     */
    public static int countPrimes4(int n) {
        if (n < 3) {
            return 0;
        }
        int[] num = new int[n];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (num[i] == 0) {
                counter++;
                for (int j = i * 2; j < n; j += i) {
                    num[j] = 1;
                }
            }
        }
        return counter;
    }
}
