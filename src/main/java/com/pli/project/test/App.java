package com.pli.project.test;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by lipeng on 2015/4/4.
 */
public class App {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            public String get() {
                return null;
            }
        };

    }


}