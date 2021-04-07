package com.mashibing.juc.c_020;

import java.util.concurrent.Semaphore;

public class TestSemaPhore {
    public static void main(String[] args) {
//        Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2,true);
        Thread t[] = new Thread[10];
        for (int i = 0; i < t.length; i++) {

            t[i]=new Thread() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println(Thread.currentThread().getName()+"running...");
                        Thread.sleep(2*1000);
                        System.out.println(Thread.currentThread().getName()+"running...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        s.release();
                    }
                    System.out.println("h111");
                }
            };
            t[i].start();
        }
    }
}
