package com.bycuimiao.leetcode;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Date 2019-03-29 16:57
 * @Author bycuimiao
 **/
public class QQ {
    public static void main(String[] args) {
        /*System.out.println("1234".substring(2,3));
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.toArray();
        //ReentrantReadWriteLock.WriteLock
        ArrayList arrayList = new ArrayList();
        arrayList.contains("");*/

        /*Map<String,String> map = new HashMap<>();
        map.put("a","aaa");
        map.put("b","bbb");
        Set<String> set = map.keySet();
        set.remove("a");
        //set.add("a");
        System.out.println(map.get("a"));

        Collection<String> list = map.values();

        list.forEach(x -> x = "ccc");
        list.remove("bbb");
        list.add("ddd");
        System.out.println(map.get("b"));*/

        /*System.out.println(map.get("b"));
        list.forEach(System.out::println);*/

        //B b = req.getB();
        //int num = 0;
        //while(num == 0){
        //  A a = findA();
        //  num = update(a,b);
        //}

        //一万资本
        BigDecimal money = new BigDecimal("200000");
        //平均年化
        BigDecimal rate = new BigDecimal("1.2");
        for(int i = 0 ; i < 20 ; i ++){
            money = money.multiply(rate);
        }
        System.out.println(money.toPlainString());
    }
}
