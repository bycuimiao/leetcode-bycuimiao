package com.bycuimiao.leetcode;

/**
 * @Description TODO
 * @Date 2019/12/21 7:32 下午
 * @Author bycuimiao
 **/
public class Foo {
    public Foo() {

    }

    private volatile int flag = 0;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (flag != 0){
            //System.out.println("printFirst wait");
            Thread.sleep(200);
        }
        printFirst.run();
        flag ++;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (flag != 1){
            //System.out.println("printSecond wait");
            Thread.sleep(200);
        }
        printSecond.run();
        flag ++;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (flag != 2){
            //System.out.println("printThird wait");
            Thread.sleep(200);
        }
        printThird.run();
    }


    public static void main(String[] args) {
        Foo foo = new Foo();
        try {
            foo.third(new Runnable() {
                @Override
                public void run() {
                    System.out.println("printThird");
                }
            });
            foo.first(new Runnable() {
                @Override
                public void run() {
                    System.out.println("printFirst");
                }
            });
            foo.second(new Runnable() {
                @Override
                public void run() {
                    System.out.println("printSecond");
                }
            });

        }catch (Exception e){

        }

    }


}
