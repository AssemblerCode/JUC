package com.mashibing.juc.com.xinlian.juc;

public class Mgr06 {
    private static  Mgr06 INSTANCE;

    private Mgr06(){

    }

    public static void main(String[] args) {
        Thread t[]=new Thread[100];
        for(int i=0;i<10;i++){
            t[i]=new Thread("thread-"+i){
                @Override
                public void run() {
                    Mgr06 instance = getInstance();
                    System.out.println(Thread.currentThread().getName()+INSTANCE);
                }
            };
            t[i].start();
        }
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    INSTANCE=new Mgr06();
                }
            }
        }

        return INSTANCE;
    }
}
