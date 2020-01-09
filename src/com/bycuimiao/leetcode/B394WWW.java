package com.bycuimiao.leetcode;

import java.util.Stack;

/**
 * @Description
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/25 10:55 下午
 * @Author bycuimiao
 **/
public class B394WWW {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();

        return null;
    }
    public String decodeOne(String s) {
        char[] chars = s.toCharArray();
        String numStr = "";
        int num = 0;
        String alphabet = "";
        String res = "";
        for(int i = 0 ; i < chars.length ; i ++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                //数字
                numStr = numStr + chars[i];
            }else if(chars[i] == '['){
                //括号
                num = Integer.parseInt(numStr);
            }else if (chars[i] == ']'){
                //括号
                for(int j = 0 ; j < num ; j ++){
                    res = res + alphabet;
                }
                num = 0;
                numStr = "";
                alphabet = "";
            }else {
                //字母
                alphabet = alphabet + chars[i];
            }
        }
        return res;
    }

    public int getType(char c){
        if(c >= '0' && c <= '9'){
            return 1;
        }else if(c == '[' || c == ']'){
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        B394WWW obj = new B394WWW();
        System.out.println(obj.decodeOne("3[a]2[bc]"));
        //System.out.println(obj.decodeString("3[a]2[bc]"));
    }
}
