package com.mashibing.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
			boolean offer = strs.offer("a" + i);//add
//			strs.add("a" + i); offer��add����һ�µģ���ʵadd������ľ���offer����
			boolean add = strs.add("a" + i);
		}

        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());//����peek����������ȡ������ͷ���Ժ��ɾ����
        System.out.println(strs.size());

        System.out.println(strs.peek());
        System.out.println(strs.size());

        //˫�˶���Deque
    }
}
