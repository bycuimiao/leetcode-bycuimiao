package com.bycuimiao.leetcode;

/**
 * @Description
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/20 11:05 下午
 * @Author bycuimiao
 **/
public class B11 {
    public int maxArea(int[] height) {
        int max = 0;
        int tmp = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j){
            tmp = getArea(height[i],height[j],i,j);
            if(tmp > max){
                max = tmp;
            }
            if(height[i] < height[j]){
                i ++;
            }else {
                j --;
            }
        }
        return max;
    }

    public int getArea(int a ,int b ,int i ,int j){
        return Math.min(a,b) * (j - i);
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        B11 obj = new B11();
        int max = obj.maxArea(height);
        System.out.println(max);
    }
}
