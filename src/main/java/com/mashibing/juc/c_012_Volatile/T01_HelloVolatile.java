/**
 * volatile �ؼ��֣�ʹһ�������ڶ���̼߳�ɼ�
 * A B�̶߳��õ�һ��������javaĬ����A�߳��б���һ��copy���������B�߳��޸��˸ñ�������A�߳�δ��֪��
 * ʹ��volatile�ؼ��֣����������̶߳�������������޸�ֵ
 * <p>
 * ������Ĵ����У�running�Ǵ����ڶ��ڴ��t������
 * ���߳�t1��ʼ���е�ʱ�򣬻��runningֵ���ڴ��ж���t1�̵߳Ĺ������������й�����ֱ��ʹ�����copy��������ÿ�ζ�ȥ
 * ��ȡ���ڴ棬�����������߳��޸�running��ֵ֮��t1�̸߳�֪���������Բ���ֹͣ����
 * <p>
 * ʹ��volatile������ǿ�������̶߳�ȥ���ڴ��ж�ȡrunning��ֵ
 * <p>
 * �����Ķ���ƪ���½��и���������
 * http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * <p>
 * volatile�����ܱ�֤����̹߳�ͬ�޸�running����ʱ�������Ĳ�һ�����⣬Ҳ����˵volatile�������synchronized
 *
 * @author mashibing
 */
package com.mashibing.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
    boolean running = true; //�Ա�һ������volatile������£������������н��������

    void m() {
        System.out.println("m start" + Thread.currentThread().getName());
//        synchronized (this) {
        while (running) {
//                running = false;
//                System.out.println(running + Thread.currentThread().getName());
//            }
        }
        System.out.println("m end!" + Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        T01_HelloVolatile t1 = new T01_HelloVolatile();

        new Thread(t::m, "t").start();
//        new Thread(t1::m, "t1").start();
//        new Thread(){
//            @Override
//            public void run() {
//                t.m();
//            }
//        }.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }

}


