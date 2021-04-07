package com.mashibing.juc.c_023_02_FromHashtableToCHM;

import java.util.HashMap;
import java.util.UUID;

public class TestHashMapReadWrite {
    static UUID keys[] = new UUID[100 * 100 * 100];
    static UUID values[] = new UUID[100 * 100 * 100];
    static int count = Constants.COUNT;
    static final int THREAD_COUNT = Constants.THREAD_COUNT;
    static HashMap<UUID, UUID> map = new HashMap<>();

    static {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start;
        int gap = count/THREAD_COUNT;
        public MyThread(int start){
            this.start=start;
        }

        @Override
        public void run() {
            for(int i=start;i<gap+start;i++){
                map.put(keys[i],values[i]);
            }
        }
    }

    private static void createThreads(){
        MyThread threads[] = new MyThread[100];
        for(int i=0;i<threads.length;i++){
            MyThread m=new MyThread(10000*i);
            threads[i]=m;
            threads[i].start();
        }
        for(int i=0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long  startTime=System.currentTimeMillis();
        createThreads();// 效率很慢
        long  endTime=System.currentTimeMillis();
        System.out.println("endTime-startTime="+(endTime-startTime));
    }
}
