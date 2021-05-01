package com.mashibing.juc.c_026_01_ThreadPool;

import com.mashibing.juc.c_001.T;

import java.util.concurrent.*;

public class RejectionPolicies implements RejectedExecutionHandler {

    public static void main(String[] args) {
        RejectionPolicies rejectionPolicies=new RejectionPolicies();

        ThreadPoolExecutor executor= new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),rejectionPolicies);
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        /**
         * 一般被拒绝的任务可以打印一下或保存到redis、mq里面
         */
    }
}
