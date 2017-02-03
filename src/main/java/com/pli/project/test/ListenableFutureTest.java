package com.pli.project.test;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by lipeng on 2015/4/4.
 */
public class ListenableFutureTest {

    public static void main(String[] args) {
        tryListenableFuture();
    }

    public static void tryListenableFuture() {
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        final com.google.common.util.concurrent.ListenableFuture<String> future = pool.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("1");
                Thread.sleep(3000);
                return "abcde";
            }
        });

        future.addListener(new Runnable() {
            public void run() {
                try {
                    final String contents = future.get();
                    System.out.println(contents);
                    //...process web site contents
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                } catch (ExecutionException e) {
                    System.out.println("exception");
                }
            }
        }, MoreExecutors.sameThreadExecutor());

        System.out.println("hey");
    }


}