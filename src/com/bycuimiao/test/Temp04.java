package com.bycuimiao.test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Date 2019/10/30 11:10 下午
 * @Author bycuimiao
 **/
public class Temp04 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(10088);
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
            while (true){
                Socket socket = ss.accept();
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }catch (Exception e){

        }
    }
}
