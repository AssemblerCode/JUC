package com.mashibing.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //容量为0
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());//如果队列里面没有内存就阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //阻塞等待消费者消费
        strs.put("aaa"); //阻塞等待消费者消费
        //strs.put("bbb");
//		strs.add("aaa");如果没有线程事先调用take方法消费则报异常
        System.out.println(strs.size());
    }
}
