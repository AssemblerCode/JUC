package com.mashibing.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(20,new Thread(){
            @Override
            public void run() {
                System.out.println("已经到了上限了");
            }
        });
        Thread t[]=new Thread[20];
        for(int i=0;i<t.length;i++){
            t[i]=new Thread(){
                @Override
                public void run() {
                    try {
                        barrier.await();
                        System.out.println("go go go!!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            t[i].start();
        }
    }
}
