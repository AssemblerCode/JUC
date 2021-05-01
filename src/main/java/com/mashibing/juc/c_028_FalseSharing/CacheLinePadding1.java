package com.mashibing.juc.c_028_FalseSharing;

public class CacheLinePadding1 {

    private static class T extends  Padding {
        public volatile long x = 0L;
    }

    private static class Padding{
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static T t[]=new T[2];

    static {
        t[0]=new T();
        t[1]=new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run() {
                for (long i = 0; i < 1000_0000L; i++) {
                    t[0].x = i;
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                for (long i = 0; i < 1000_0000L; i++) {
                    t[1].x = i;
                }
            }
        };
        final long startTime=System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - startTime)/100_0000);
    }
}
