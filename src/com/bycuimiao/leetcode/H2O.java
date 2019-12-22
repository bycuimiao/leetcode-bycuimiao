package com.bycuimiao.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Date 2019/12/22 3:46 下午
 * @Author bycuimiao
 **/
public class H2O {
    public H2O() {
        semaphoreH = new Semaphore(2);
        semaphoreO = new Semaphore(1);
    }

    private Semaphore semaphoreH;
    private Semaphore semaphoreO;
    private CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            semaphoreH.release(2);
            semaphoreO.release();
        }
    });


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        H2O obj = new H2O();
        try {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("H");
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
                        obj.oxygen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("O");
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
                        obj.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("H");
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
                        obj.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("H");
                            }
                        });
                    }catch (Exception e){

                    }
                }
            });
            Thread t5 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.oxygen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("O");
                            }
                        });
                    }catch (Exception e){

                    }
                }
            });
            Thread t6 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("H");
                            }
                        });
                    }catch (Exception e){

                    }
                }
            });
            t1.start();
            t5.start();
            t6.start();
            t2.start();
            t3.start();
            t4.start();
            while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive() || t6.isAlive()){
                Thread.sleep(1);
            }
        }catch (Exception e){

        }

    }
}
