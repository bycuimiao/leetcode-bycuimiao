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
     * @param num
     * @return
     */
    public String intToRoman(int num) {
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

    public static void main(String[] args) {
        B12 obj = new B12();
        System.out.println(obj.intToRoman(3));
        System.out.println(obj.intToRoman(4));
        System.out.println(obj.intToRoman(9));
        System.out.println(obj.intToRoman(58));
        System.out.println(obj.intToRoman(1994));
    }
}
