package com.bycuimiao.leetcode;

import java.util.*;

/**
 * @Description
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/23 9:17 下午
 * @Author bycuimiao
 **/
public class B49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String ,List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i ++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.get(key) == null){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
                lists.add(list);
            }else {
                List<String> list = map.get(key);
                list.add(str);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        B49 obj = new B49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        obj.groupAnagrams(strs);
    }
}
