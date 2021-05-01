package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class SingleThreadPool {
    private static ExecutorService service = null;

    public SingleThreadPool() {
        SingleThreadPool.service = createSingleThreadPool();
    }

    public SingleThreadPool(ExecutorService service) {
        SingleThreadPool.service = service;
    }

    public ExecutorService getService() {
        return service;
    }

    private static ExecutorService createSingleThreadPool() {
        return Executors.newSingleThreadExecutor();
    }

    public static void main(String[] args) {
        SingleThreadPool pool = new SingleThreadPool();
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            int c = i;
        }
    }
}
