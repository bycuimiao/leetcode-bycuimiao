package com.bycuimiao.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description TODO
 * @Date 2019/12/21 9:16 下午
 * @Author bycuimiao
 **/
class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n;i++) {
            z.acquire();
            printNumber.accept(0);
            if((i&1)==0) {
                o.release();
            }else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public static void main(String[] args) {
        try {
            ZeroEvenOdd obj = new ZeroEvenOdd(2);
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.zero(System.out::println);
                    }catch (Exception e){

                    }

                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.odd(System.out::println);
                    }catch (Exception e){

                    }

                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.even(System.out::println);
                    }catch (Exception e){

                    }

                }
            });

            t1.start();
            t2.start();
            t3.start();
            while (t1.isAlive() || t2.isAlive() || t3.isAlive()){
                Thread.sleep(10);
            }
        }catch (Exception e){

        }


    }
}