package com.bycuimiao.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/20 11:46 下午
 * @Author bycuimiao
 **/
public class B43 {
    /**
     * 592 ms	64.2 MB
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        String[] strs = new String[chars1.length * chars2.length];
        String[] strsZero = new String[chars1.length * chars2.length];
        int n = 0;
        for(int i = chars1.length - 1 ; i >= 0 ; i --){
            for(int j = chars2.length - 1 ; j >=0 ; j --){
                strs[n] = charMultiply(chars1[i],chars2[j]);
                strsZero[n] = addZero(i,j,chars1.length,chars2.length);
                n ++;
            }
        }
        String[] strsNum = new String[strs.length];
        int maxLen = 0;
        for(int i = 0 ; i < strsNum.length ; i ++){
            if(strs[i] != null && !"0".equals(strs[i])){
                strsNum[i] = strs[i] + strsZero[i];
                if(strsNum[i].length() > maxLen){
                    maxLen = strsNum[i].length();
                }
            }
        }
        String[] strsRes = new String[maxLen];
        //List<String> list = new ArrayList<>();
        int jinwei = 0;
        for(int i = 0 ; i < maxLen ; i ++){
            int sum = 0;
            for(int j = 0 ; j < strsNum.length ; j ++){
                if(strsNum[j] != null && !strsNum[j].equals("0") && i < strsNum[j].length()){
                    sum = sum + getNum(strsNum[j],i);
                }
            }
            sum = sum + jinwei;
            if(sum > 9){
                strsRes[i] = String.valueOf(sum).substring(String.valueOf(sum).length()-1);
                jinwei = Integer.valueOf(String.valueOf(sum).substring(0,String.valueOf(sum).length()-1));
            }else {
                strsRes[i] = String.valueOf(sum);
                jinwei = 0;
            }
            //strsRes[i] = String.valueOf(getNum(String.valueOf(sum),String.valueOf(sum).length()-1));
        }
        boolean flag = true;
        String res = "";
        for(int i = strsRes.length-1 ; i >=0 ; i --){
            if(strsRes[i] == null && flag){
                continue;
            }
            flag = false;
            res = res + strsRes[i];
        }
        if(jinwei != 0){
            res = jinwei + res;
        }
        return res;
    }

    public Integer getNum(String str , int i){
        if(i < str.length()){
            char[] chars = str.toCharArray();
            return chars[str.length()-i-1] - 48;
        }
        return 0;
    }

    public String charMultiply(char a , char b){
        Integer res = (a-48)*(b-48);
        return String.valueOf(res);
    }

    public String addZero(int i , int j , int leni , int lenj){
        String zero = "";
        int n = (leni - i - 1) + (lenj - j - 1);
        while (n > 0){
            zero = zero + "0";
            n --;
        }
        return zero;
    }

    public static void main(String[] args) {
        String num1 = "9133", num2 = "0";
        B43 obj = new B43();
        String num3 = obj.multiply(num1,num2);
        System.out.println(num3);

        System.out.println(new BigDecimal("123456789").multiply(new BigDecimal("987654321")));
    }
}
