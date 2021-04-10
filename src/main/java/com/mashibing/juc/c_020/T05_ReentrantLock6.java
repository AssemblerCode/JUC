/**
 * reentrantlock�������synchronized
 * ����m1����this,ֻ��m1ִ����ϵ�ʱ��,m2����ִ��
 * �����Ǹ�ϰsynchronized��ԭʼ������
 * <p>
 * ʹ��reentrantlock�������ͬ���Ĺ���
 * ��Ҫע����ǣ�����Ҫ����Ҫ����Ҫ�ֶ��ͷ�������Ҫ������˵���飩
 * ʹ��syn�����Ļ���������쳣��jvm���Զ��ͷ���������lock�����ֶ��ͷ�������˾�����finally�н��������ͷ�
 * <p>
 * ʹ��reentrantlock���Խ��С�����������tryLock�������޷�������������ָ��ʱ�����޷��������߳̿��Ծ����Ƿ�����ȴ�
 * <p>
 * ʹ��ReentrantLock�����Ե���lockInterruptibly���������Զ��߳�interrupt����������Ӧ��
 * ��һ���̵߳ȴ����Ĺ����У����Ա����
 * <p>
 * ReentrantLock������ָ��Ϊ��ƽ��
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
