package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class RabbitmqApplicationTests {

    private static final int CHARS_PER_THREAD = 1_000_000;
    private static final int NUMBER_OF_THREADS = 4;

    private StringBuilder builder;

    @Before
    public void setUp() {
        builder = new StringBuilder();
    }

    @Test
    public void testStringBuilder() throws ExecutionException, InterruptedException {
        Runnable appender = () -> {
            for (int i = 0; i < CHARS_PER_THREAD; i++) {
                builder.append('A');
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            futures.add(executorService.submit(appender));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        executorService.shutdown();
        String builtString = builder.toString();
        Assert.assertEquals(CHARS_PER_THREAD * NUMBER_OF_THREADS, builtString.length());
    }
}
