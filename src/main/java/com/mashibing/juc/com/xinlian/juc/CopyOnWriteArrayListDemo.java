package com.mashibing.juc.com.xinlian.juc;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList list=new CopyOnWriteArrayList();
        String str="HelloWorld";
        list.add(str);
        System.out.println(list.get(0));
    }
}
