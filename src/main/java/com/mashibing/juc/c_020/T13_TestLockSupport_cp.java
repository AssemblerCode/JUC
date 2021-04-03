package com.mashibing.juc.c_020;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class T13_TestLockSupport_cp {
//    public static void main(String[] args) {
//        Thread t = new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//                if(i == 5) {
//                    LockSupport.park();
//                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t.start();
//
//        LockSupport.unpark(t);

        /*try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);*/

    //    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        Thread t = new Thread("t") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread.name=" + Thread.currentThread().getName() + ",i=" + i);
                    if (i == 5) {
                        LockSupport.park();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        LockSupport.unpark(t);//启动线程之前调用解除阻塞是无用的，只有在启动线程之后调用解除阻塞的方法才行
        t.start();
//        t.start();
//        LockSupport.unpark(t);//启动线程之后调用解除阻塞才是有用的

    }
}
