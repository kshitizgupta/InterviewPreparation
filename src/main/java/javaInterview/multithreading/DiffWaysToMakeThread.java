package javaInterview.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DiffWaysToMakeThread {

    static class MyThreadClass extends Thread {
        @Override
        public void run() {
            System.out.println("Thread " + getName() + " running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadCallable implements Callable<Integer> {
        final private int num;

        public MyThreadCallable(final int i) {
            this.num = i;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("Thread " + Thread.currentThread().getName() + " running");
            Thread.sleep(3000);
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Submitting Extendable");
        MyThreadClass myThreadClass = new MyThreadClass();
        myThreadClass.start();
        myThreadClass.join();

        System.out.println("Submitting Runnable");
        Runnable myThreadRunnable = new MyThreadRunnable();
        Thread t1 = new Thread(myThreadRunnable, "Runnable");
        t1.start();
        t1.join();

        System.out.println("Submitting Callable");
        Callable<Integer> myThreadCallable = new MyThreadCallable(3);
        final FutureTask<Integer> target = new FutureTask<>(myThreadCallable);
        Thread t2 = new Thread(target, "Callable");
        t2.start();
        t2.join();

        System.out.println("using Lambda Runnable");
        Thread t3 = new Thread(() -> {
            System.out.println("Thread + " + Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "UsingLambda");
        t3.start();
        t3.join();

        System.out.println("Using executor service");
        Callable<Integer> myThreadCallable1 = new MyThreadCallable(4);
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> ft = es.submit(myThreadCallable1);

        int out = ft.get();
        System.out.println("Finished : " + out);

    }
}
