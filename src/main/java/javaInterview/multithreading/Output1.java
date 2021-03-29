package javaInterview.multithreading;

class Output1 extends Thread
{
    Output1() {}
    Output1(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        new Output1().start();
        new Output1(new RunnableDemo()).start();
    }
}