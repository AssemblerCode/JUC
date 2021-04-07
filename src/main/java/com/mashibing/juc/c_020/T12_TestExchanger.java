package com.mashibing.juc.c_020;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            String name="asgrwesdrgherwsh";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + s+ "," +name);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            String name="asgrwe";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + s+ "," +name);


        }, "t2").start();


    }
}
