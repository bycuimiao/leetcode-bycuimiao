package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/9 9:17 上午
 * @Author bycuimiao
 **/
public class BQ93 {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4){
            //不可能存在可用ip，ip是4个8位二进制数组成，每位都在0~255之间
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int len = s.length();
        //backtrack(0, "", 4, s, res, len);

        backtracking(s,0,new ArrayList<>() ,res);
        return null;
    }

    private void backtrack(int i, String tmp, int dot, String s, List<String> res, int len) {
        if (i == len && dot == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (dot < 0) return;
        for (int j = i; j < i + 3; j++) {
            if (j < len) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, tmp + s.charAt(j) + ".", dot - 1, s, res, len);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255)
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", dot - 1, s, res, len);
            }
        }
    }


    // cur : 当前答案，以 String List的形式，最后再join成String形式 例如 [[255],[255],[111],[35]] -> 255.255.111.35
    // pos, 当前扫描到的s的位置， ans最终答案
    private void backtracking(String s, int pos, List<String> curRes,  List<String> finalRes) {
        if (curRes.size() >= 4) {
            if (pos == s.length()) finalRes.add(String.join(".", curRes));
            return;
        }
        // 分割得到ip地址的一段后，下一段只能在长度1-3范围内选择
        for (int i = 1; i <= 3; i++) {
            if (pos+i > s.length()) break;
            String segment = s.substring(pos, pos+i);
            // 剪枝条件：不能以0开头，不能大于255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) continue;
            curRes.add(segment);
            // 注意此处传的参数
            backtracking(s, pos+i, curRes, finalRes);
            curRes.remove(curRes.size()-1);
        }
    }

    public static void main(String[] args) {
        BQ93 obj = new BQ93();
        List<String> ips = obj.restoreIpAddresses("25525511135");
        ips.forEach(ip -> System.out.println(ip));
    }
}
