package com.mashibing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class JustTest {
    private static boolean getLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        return lock.tryLock(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

//        Object o = new Object();

        new Thread("thread01") {
            @Override
            public void run() {
//                ReentrantLock lock = new ReentrantLock();
//                ReentrantLock reentrantLock = new ReentrantLock();
//                try {
//                    boolean b = lock.tryLock(5, TimeUnit.SECONDS);
//                    System.out.println(b);
//                    b = reentrantLock.tryLock(5, TimeUnit.SECONDS);
//                    System.out.println(b);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
                try {
                    boolean lock = getLock();
                    System.out.println(lock);
                    lock = getLock();
                    System.out.println(lock);
                    lock = getLock();
                    System.out.println(lock);
                    lock = getLock();
                    System.out.println(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
