package com.bycuimiao.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Description TODO
 * @Date 2019/12/22 8:37 下午
 * @Author bycuimiao
 **/
public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    /**
     * 原子变量
     */
    private AtomicInteger integer = new AtomicInteger(1);

    /**
     * 状态锁
     */
    private Object lock = new Object();

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 3 == 0 && num % 15 != 0) {
                    printFizz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 5 == 0 && num % 15 != 0) {
                    printBuzz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 15 == 0) {
                    printFizzBuzz.run();
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (integer.get() <= n) {
            synchronized (lock) {
                int num = integer.get();
                if (num % 3 != 0 && num % 5 != 0) {
                    printNumber.accept(num);
                    integer.getAndIncrement();
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            FizzBuzz obj = new FizzBuzz(15);
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //obj.zero(System.out::println);
                        obj.fizz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizz");
                            }
                        });
                    }catch (Exception e){

                    }

                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //obj.zero(System.out::println);
                        obj.buzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("buzz");
                            }
                        });
                    }catch (Exception e){

                    }

                }
            });

            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //obj.zero(System.out::println);
                        obj.fizzbuzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizzbuzz");
                            }
                        });
                    }catch (Exception e){

                    }

                }
            });

            Thread t4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //obj.zero(System.out::println);
                        obj.number(System.out::println);
                    }catch (Exception e){

                    }

                }
            });

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()){
                Thread.sleep(1);
            }
        }catch (Exception e){

        }

    }
}
