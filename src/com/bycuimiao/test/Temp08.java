package com.bycuimiao.test;

import java.util.HashMap;

/**
 * @author miao.cui
 * @description: TODO
 * @date 2019-12-18 17:11
 */
public class Temp08 {
    public static void main(String[] args) {
        //不会有误差，因为4.75在转换二进制的时候不会有精度损失
        //System.out.println(4.75 + 4.75 + 4.75);
        //会有误差，因为4.2在转换二进制的时候会有精度损失
        //System.out.println(4.2 + 4.2 + 4.2);

        //HashMap
        System.out.println(tableSizeFor(20));
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(tableSizeFor(Integer.MAX_VALUE-1));
        System.out.println("--------------");
        System.out.println((1 << 31) -1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("--------------");
        int a ;
        System.out.println(a = 1+2);

    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        /*if(key == null){
            return 0;
        }else {
            int a = (h = key.hashCode());
            int b = a >>> 16;
            return b;
        }*/
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
