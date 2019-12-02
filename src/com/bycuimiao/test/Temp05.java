package com.bycuimiao.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/12/1 4:36 下午
 * @Author bycuimiao
 **/
public class Temp05 {
    public static void main(String[] args) {
        List<List> list = new ArrayList<>();
        list.add(list);
        System.out.println(list.get(0).equals(list));
    }
}
