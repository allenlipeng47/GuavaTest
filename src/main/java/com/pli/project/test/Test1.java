package com.pli.project.test;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lipeng on 2017/2/2.
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        Function function = (a) -> {return 1;};
        System.out.println(function.apply("asdf"));
    }

    public static void listenablFutureTest() throws Exception{
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> future = service.submit(() -> {
            return 1;
        });
        Futures.transform(future, new Function<Integer, String>() {
            public String apply(Integer input) {
                return "123";
            }
        });
//        Futures.transform(future, (a) -> {return "123";});
        System.out.println(future.get());
    }

    public static void futureTest() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(() -> {return 1;});
        System.out.println(future.get());
        B b = () -> {};

    }

    public interface B {
        public void apply();
    }



}
