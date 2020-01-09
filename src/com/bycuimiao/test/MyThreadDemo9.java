package com.bycuimiao.test;

/**
 * @author miao.cui
 * @description: TODO
 * @date 2020/1/9 上午10:17
 */
public class MyThreadDemo9 extends Thread {
    private static volatile int count = 0;
    public String status;

    public MyThreadDemo9(String status) {
        this.status = status;
    }

    @Override
    public void run() {
        synchronized (MyThreadDemo9.class) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
           
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadDemo9 t1 = new MyThreadDemo9("Thread status - " + 1);
        t1.start();
        MyThreadDemo9 t2 = new MyThreadDemo9("Thread status - " + 2);
        t2.start();
        MyThreadDemo9 t3 = new MyThreadDemo9("Thread status - " + 2);
        t3.start();
        if (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            Thread.sleep(1000);
        }
        System.out.println(MyThreadDemo9.count);
    }

}
