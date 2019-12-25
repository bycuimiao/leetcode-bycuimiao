package com.bycuimiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/24 11:59 下午
 * @Author bycuimiao
 **/
public class A202 {


    /**
     * 3 ms	33.9 MB
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = happy(n);
        }
        return true;
    }

    public boolean isHappy(int n) {
        int slow = happy(n);
        int fast = happy(happy(n));
        while (slow != fast){
            slow = happy(slow);
            fast = happy(happy(fast));
        }
        return slow == 1;
    }


    public int happy(int n){
        int sum = 0;
        while(n > 0)
        {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        //System.out.println((int)'1' - 48);
        A202 obj = new A202();
        System.out.println(obj.isHappy(19));
    }
}
