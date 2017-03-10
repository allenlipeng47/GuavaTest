package com.pli.project.test;

import java.util.concurrent.*;

/**
 * Created by lipeng on 2017/3/9.
 */
public class SubmitExecute {

    public static void main(String[] args) throws Exception{
        executeCallable();
    }

    public static void submitCallable() throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> r = () -> {
            return "abcd";
        };
        Future<String> future = executorService.submit(r);
        System.out.println(future.get());
        executorService.shutdown();
    }

    public static void submitRunnable() throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable r = () -> {
            System.out.println(1);
        };
        Future future = executorService.submit(r);
        System.out.println(future.get());   // future of submitting a runnable is always null
        executorService.shutdown();
    }

    public static void executeCallable() throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable r = () -> {
            System.out.println("abcd");
        };
        executorService.execute(r);
        executorService.shutdown();
    }
}
