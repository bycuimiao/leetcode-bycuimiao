package com.bycuimiao.test;

/**
 * @author miao.cui
 * @description: TODO
 * @date 2019-12-18 17:11
 */
public class Temp08 {
    public static void main(String[] args) {
        //不会有误差，因为4.75在转换二进制的时候不会有精度损失
        System.out.println(4.75 + 4.75 + 4.75);
        //会有误差，因为4.2在转换二进制的时候会有精度损失
        System.out.println(4.2 + 4.2 + 4.2);
    }
}
