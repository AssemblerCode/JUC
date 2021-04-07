package com.mashibing.juc.c_022_RefTypeAndThreadLocal;

public class M {
    private String name="jinwh";

    public String getName(){
        return name;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
