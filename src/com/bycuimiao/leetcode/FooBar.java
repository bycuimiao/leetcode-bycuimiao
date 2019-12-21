package com.bycuimiao.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/12/21 9:02 下午
 * @Author bycuimiao
 **/
class FooBar {
    private int n;

    private volatile int flag = 0;

    ///
    private ReentrantLock lock = new ReentrantLock();

    private Condition fooTurn = lock.newCondition();
    private Condition barTurn = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo1(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag != 0){
                Thread.sleep(10);
            }
            flag = 1;

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar1(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag != 1){
                Thread.sleep(10);
            }
            flag = 0;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}