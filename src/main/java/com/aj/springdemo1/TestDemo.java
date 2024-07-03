package com.aj.springdemo1;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Test");
        TestDemo demo = new TestDemo();
        String op = demo.getProducts();
        System.out.println("OP = "+op);
        System.out.println("Final message");
    }

    public String getProducts() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::getProduct).thenApply(this::enhanceProduct);
        return future.get();

    }

    private String enhanceProduct(String obj) {
        return obj+" Enhance Product";
    }

    private String getProduct() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Get Product";
    }

}
