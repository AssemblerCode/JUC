package com.mashibing.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
			boolean offer = strs.offer("a" + i);//add
//			strs.add("a" + i); offer和add的是一致的，其实add里面调的就是offer方法
			boolean add = strs.add("a" + i);
		}

        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());//他和peek的区别是他取出队列头部以后会删掉的
        System.out.println(strs.size());

        System.out.println(strs.peek());
        System.out.println(strs.size());

        //双端队列Deque
    }
}
