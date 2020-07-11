package javaInterview.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class DiffWaysToMakeThread {

    static class MyThreadClass extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread extending class");
            }
        }
    }

    static class MyThreadRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread implementing Runnable");
            }
        }
    }

    static class MyThreadCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child thread implementing Callable");
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Submitting Extendable");
        MyThreadClass myThreadClass = new MyThreadClass();
        myThreadClass.start();

        System.out.println("Submitting Runnable");
        Runnable myThreadRunnable = new MyThreadRunnable();
        Thread t1 = new Thread(myThreadRunnable);
        t1.start();

        System.out.println("Submitting Callable");
        Callable<Integer> myThreadCallable = new MyThreadCallable();
        Thread t2 = new Thread(new FutureTask<Integer>(myThreadCallable));
        t2.start();
    }
}
