package com.mashibing.juc.c_025;

import java.util.PriorityQueue;

public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

//        q.add("c");
//        q.add("e");
//        q.add("a");
//        q.add("d");
//        q.add("z");

        q.add("4");
        q.add("2");
        q.add("3");
        q.add("5");
        q.add("1");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
