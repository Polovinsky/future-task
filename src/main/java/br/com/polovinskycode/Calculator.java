package br.com.polovinskycode;

import br.com.polovinskycode.domain.funtion.Multiply;
import br.com.polovinskycode.domain.funtion.Sum;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {

    public void calc(long x, long y) throws ExecutionException, InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(2);

        List<Callable<Long>> callables = Arrays.asList(
                new Sum(x, y),
                new Multiply(x, y));

        exec.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);

        exec.shutdown();
    }

    public static void main(String... args) throws ExecutionException, InterruptedException {
        Calculator c = new Calculator();
        c.calc(10L, 56L);
    }
}
