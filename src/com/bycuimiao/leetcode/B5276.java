package com.bycuimiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/12/1 11:28 上午
 * @Author bycuimiao
 **/
public class B5276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int a = tomatoSlices / 4;
        //大汉堡数量
        int bigNum = a;
        //剩下的奶酪数量
        int cheese = cheeseSlices - bigNum;
        //剩下的番茄数量
        int tomato = tomatoSlices - bigNum * 4;
        //小汉堡的数量
        int smallNum = 0;
        if(cheese == tomato / 2){
            smallNum = cheese;
        }else {
            while (cheese != tomato / 2 && bigNum >=0 && smallNum>=0){
                bigNum -- ;
                cheese = cheeseSlices - bigNum;
                tomato = tomatoSlices - bigNum * 4;
                smallNum = cheese;
            }
        }
        if(bigNum < 0 || cheeseSlices != bigNum + smallNum || tomatoSlices != bigNum*4 + smallNum * 2){
            return new ArrayList<>();
        }
        list.add(bigNum);
        list.add(smallNum);
        return list;
    }

    public static void main(String[] args) {
        B5276 obj = new B5276();
        obj.numOfBurgers(17,4).forEach(System.out::println);
    }
}
