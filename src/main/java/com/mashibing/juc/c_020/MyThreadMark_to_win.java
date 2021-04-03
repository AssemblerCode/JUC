package com.mashibing.juc.c_020;

public class MyThreadMark_to_win  extends Thread{
    private  boolean stop;
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (stop) {
                System.out.println("退出了");
                throw new ArithmeticException("divide by 0");
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();

            }
            System.out.println("i = " + i);
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) {
        MyThreadMark_to_win mt = new MyThreadMark_to_win();
        mt.start();
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }
        mt.setStop(true);
    }
}
