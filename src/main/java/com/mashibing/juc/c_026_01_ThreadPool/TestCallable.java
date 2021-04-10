package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable c=new Callable() {
            @Override
            public Object call() throws Exception {
                return "hello Callable";
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();//创建线程池
        Future submit = service.submit(c);//线程池去执行c对象的call方法,而且是异步执行,也就是说main线程走到这一步以后还会继续往下走
        System.out.println(submit.get());//线程池执行完c对象的call方法,调用get方法拿到执行完成以后的结果值,但是get方法会阻塞的
        service.shutdown();//关闭线程池
    }
}
