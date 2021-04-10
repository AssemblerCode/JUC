package com.mashibing.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //����Ϊ0
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());//�����������û���ڴ������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //�����ȴ�����������
        strs.put("aaa"); //�����ȴ�����������
        //strs.put("bbb");
//		strs.add("aaa");���û���߳����ȵ���take�����������쳣
        System.out.println(strs.size());
    }
}
