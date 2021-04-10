/**
 * reentrantlock用于替代synchronized
 * 由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 * <p>
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * <p>
 * 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * <p>
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * <p>
 * ReentrantLock还可以指定为公平锁
 *
 * @author mashibing
 */
package com.mashibing.juc.c_020;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class T05_ReentrantLock6 {
    ReentrantLock lock = new ReentrantLock( );

    void getName() {
        AtomicInteger i=new AtomicInteger();
        i.incrementAndGet();
        lock.lock();
        System.out.println("Thread.name=" + Thread.currentThread().getName());
        lock.unlock();
    }

    public static void main(String[] args) {
        T05_ReentrantLock6 r = new T05_ReentrantLock6();

        Thread t[] = new Thread[5];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread() {
                @Override
                public void run() {
                    r.getName();
                }
            };
            t[i].start();
        }
    }
}
