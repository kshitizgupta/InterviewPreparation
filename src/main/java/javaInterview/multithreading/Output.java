package javaInterview.multithreading;

public class Output implements Runnable{
    int x = 0, y = 0;
    int addX() {x++; return x;}
    int addY() {y++; return y;}
    @Override
    public void run() {
        for(int i = 0; i < 10; i++)
            System.out.println( Thread.currentThread().getName() + ": " +addX() + " " + addY());
    }

    public static void main(String[] args) {
        Output obj1 = new Output();
        Output obj2 = new Output();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}
