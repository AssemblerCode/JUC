package com.mashibing.juc.com.xinlian.juc;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {
    private volatile static int count = 0;

    public static void main(String[] args) {
        Thread t[] = new Thread[10];
        Object obj = new Object();
        demo1 demo1 = new demo1();
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread("Thread" + i) {
                @Override
                public void run() {
//                    LongAdder
                    ReentrantLock lock=new ReentrantLock(true);
                    CountDownLatch latch=new CountDownLatch(100);
                    latch.countDown();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        boolean locked = lock.tryLock(5, TimeUnit.SECONDS);
                        lock.lockInterruptibly();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (demo1.getClass()) {
                        for (int i = 0; i < 10000; i++) {
                            demo1.count += 1;
                        }
                        System.out.println(demo1.count + "." + Thread.currentThread().getName());
                    }

                }
            };
            t[i].start();
        }

    }

//    synchronized static void m() {
//
//    }
}
