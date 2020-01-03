package com.bycuimiao.leetcode;

/**
 * @Description TODO
 * @Date 2020/1/3 11:04 下午
 * @Author bycuimiao
 **/
public class B12 {
    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 37 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 智障解法
     * @param num
     * @return
     */
    public String intToRoman1(int num) {
        if(num > 3999){
            return "";
        }

        StringBuilder ans = new StringBuilder();
        int a = num / 1000;
        for(int i = 0 ; i < a ; i ++){
            ans.append("M");
        }

        num = num - a * 1000;
        int b = num / 100;
        if(b == 9){
            ans.append("CM");
        }else if(b == 4){
            ans.append("CD");
        }else if(b >= 5){
            ans.append("D");
            for(int i = 0 ; i < b - 5 ; i ++){
                ans.append("C");
            }
        }else {
            for(int i = 0 ; i < b ; i ++){
                ans.append("C");
            }
        }

        num = num - b * 100;
        int c =  num / 10;
        if(c == 9){
            ans.append("XC");
        }else if(c == 4){
            ans.append("XL");
        }else if(c >= 5){
            ans.append("L");
            for (int i = 0 ; i < c - 5 ; i ++){
                ans.append("X");
            }
        }else {
            for (int i = 0 ; i < c ; i ++){
                ans.append("X");
            }
        }

        num = num - c * 10;
        int d = num;
        if(d == 9){
            ans.append("IX");
        }else if(d == 4){
            ans.append("IV");
        }else if(d >= 5){
            ans.append("V");
            for (int i = 0 ; i < d - 5; i ++){
                ans.append("I");
            }
        }else {
            for (int i = 0 ; i < d; i ++){
                ans.append("I");
            }
        }
        return ans.toString();
    }


    /**
     * 贪心
     * 时间复杂度：O(1)O(1)，虽然看起来是两层循环，但是外层循环的次数最多 1212，内层循环的此时其实也是有限次的，综合一下，时间复杂度是 O(1)O(1)。
     * 空间复杂度：O(1)O(1)，这里使用了两个辅助数字，空间都为 1313，还有常数个变量，故空间复杂度是 O(1)O(1)
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/integer-to-roman/solution/tan-xin-suan-fa-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        B12 obj = new B12();
        System.out.println(obj.intToRoman(3));
        System.out.println(obj.intToRoman(4));
        System.out.println(obj.intToRoman(9));
        System.out.println(obj.intToRoman(58));
        System.out.println(obj.intToRoman(1994));
    }
}
