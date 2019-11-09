package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/11/9 9:53 上午
 * @Author bycuimiao
 **/
public class BQ93R1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        backtrack(s,0,new ArrayList<>() ,ips);
        return ips;
    }

    public void backtrack(String s ,
                          int pos ,
                          List<String> curRes ,
                          List<String> finalRes){
        if(curRes.size() >= 4){
            if(pos == s.length())
                finalRes.add(String.join(".",curRes));
            return;
        }
        for(int i = 0 ; i < 3 ; i ++){
            if (pos+i+1 > s.length()) break;
            String tmp = s.substring(pos,pos+i+1);
            //剪枝
            if(tmp.startsWith("0") && tmp.length() > 1) break;
            //if(tmp.equals("")) return;
            if( Long.valueOf(tmp) > 255L) break;
            curRes.add(tmp);
            backtrack(s,pos+i+1,curRes,finalRes);
            curRes.remove(curRes.size()-1);
        }
    }

    public static void main(String[] args) {
        BQ93R1 obj = new BQ93R1();
        String s = "25525511135";
        List<String> res = obj.restoreIpAddresses(s);
        res.forEach(ip -> System.out.println(ip));
    }
}
